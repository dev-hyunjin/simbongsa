package com.app.simbongsa.controller;

import com.app.simbongsa.domain.MailDTO;
import com.app.simbongsa.domain.MemberDTO;
import com.app.simbongsa.entity.member.Member;
import com.app.simbongsa.provider.UserDetail;
import com.app.simbongsa.service.member.MemberService;
import com.app.simbongsa.type.MemberJoinType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/member/*")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    /* 회원 가입 페이지 이동*/
    @GetMapping("join")
    public String gotoJoinForm(MemberDTO memberDTO) {
        return "join-login/email-join";
    }

    /* 회원가입후 login 페이지로 이동*/
    @PostMapping("join")
    public RedirectView join(MemberDTO memberDTO, String joinType) {
        memberService.join(memberDTO, passwordEncoder);
        return new RedirectView("/member/login");
    }

    /* 카카오, 네이버, 이메일 회원가입 선택 페이지 */
    @GetMapping("join-select")
    public String joinSelect() {
        return "join-login/join-select";
    }

    /* 로그인 페이지로 이동 */
    @GetMapping("login")
    public String goToLoginForm() {return "join-login/email-login";}

    /* 로그인 선택 페이지 */
    @GetMapping("login-select")
    public String loginSelect() {
        return "join-login/login-select";
    }

    /* 비밀번호 찾기 페이지 */
    @GetMapping("find-password")
    public String findPassword() {
        return "join-login/find-password";
    }

    /* 비밀번호 변경 페이지 */
    @GetMapping("change-password-email")
    public String changePassword(String memberEmail, String memberPassword, String randomKey, Model model) {
        model.addAttribute("memberEmail", memberEmail);
        model.addAttribute("randomKey", randomKey);
        model.addAttribute("randomKey", memberPassword);
        log.info("url에서 받아온 memberEmail: " + memberEmail);
        log.info("url에서 받아온 randomKey: " + randomKey);
        return "join-login/change-password";
    }

    /* 비밀번호 변경하기 */
    @GetMapping("change-password")
    @ResponseBody
    public RedirectView changePasswordOK(String memberEmail, String memberPassword, String randomKey){
        log.info("form에서 받아온 memberEmail: " + memberEmail);
        log.info("form에서 받아온 memberPassword: " + memberPassword);
        log.info("form에서 받아온 randomKey: " + randomKey);
/*        if(!memberService.getMemberByEmail(memberEmail).getRandomKey().equals(randomKey)) {
            return new RedirectView ("/member/login");
        }*/
        memberService.updatePasswordAndResetRandomKey(memberEmail, memberPassword, passwordEncoder);
        return new RedirectView("/member/login");
    }

    /* 로그아웃 */
    @GetMapping("logout")
    public void goToLogout() {;}

    /* 이메일 형식으로 화면이동 */
    @GetMapping("find-password-email-send")
    public String findPasswordEmailSend() {
        return "/join-login/find-password-email-send";
    }

    /* 이메일 보내기 */
    @PostMapping("find-password-email")
    public RedirectView findPasswordEmail(String memberEmail, RedirectAttributes redirectAttributes) {

        if(memberService.overlapByMemberEmail(memberEmail) == 0) {
            return new RedirectView("/member/find-password?result=fail");
        }

        String randomKey = memberService.randomKey();

        //    비밀번호 변경 이메일 발송시 랜덤 키 값 컬럼에 저장
        //    비밀번호 변경 완료 시 랜덤 키 컬럼 값 삭제
        memberService.updateRandomKey(memberEmail, randomKey);

        MailDTO mailDTO = new MailDTO();
        mailDTO.setAddress(memberEmail);
        mailDTO.setTitle("새 비밀번호 설정 링크입니다.");
        mailDTO.setMessage("링크: http://localhost:10000/member/change-password-email?memberEmail=" + memberEmail + "&randomKey=" + randomKey);
        memberService.sendMail(mailDTO);

//        find-password.html에서 받은 memberEmail과 위에서 생성한 randomKey를 url 파라미터로 담아주기
        redirectAttributes.addFlashAttribute("memberEmail", memberEmail);
        return new RedirectView("/member/find-password-email-send");
    }


}
