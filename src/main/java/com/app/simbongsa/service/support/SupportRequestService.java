package com.app.simbongsa.service.support;

import com.app.simbongsa.domain.InquiryDTO;
import com.app.simbongsa.domain.MemberDTO;
import com.app.simbongsa.domain.SupportRequestDTO;
import com.app.simbongsa.entity.member.Member;
import com.app.simbongsa.entity.support.SupportRequest;
import com.app.simbongsa.provider.UserDetail;
import com.app.simbongsa.search.admin.AdminSupportRequestSearch;
import com.app.simbongsa.type.RequestType;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SupportRequestService {

//    목록 전체 조회(페이징)
    public Page<SupportRequestDTO> getSupportRequest(Integer page, AdminSupportRequestSearch adminSupportRequestSearch);

//    후원 요청 상세보기
    public SupportRequestDTO getSupportRequestDetail(Long id);

//    후원 요청 삭제
    public void deleteSupportRequest(List<Long> ids);

//    후원 요청 승인 or 반려
    public void updateWaitToAccessOrDenied(List<Long> ids, RequestType requestType);

//    후원 목록 전체 조회(후원 목록 페이지)
    public Page<SupportRequestDTO> getSupportRequestAllWithPaging(Integer page, String keyword);

//    후원 상세페이지
//    public SupportRequestDTO getByIdWithSupportRequestInfo_QueryDsl(Long id);

    /* 내 후원요청목록 페이징처리해서 불러오기 */
    Page<SupportRequestDTO> getMySupportRequest(Integer page, UserDetail userDetail);

//    승인 대기 반려 수 조회
    public List<Long> countStatusWaitAccessDenied();

    default SupportRequestDTO toSupportRequestDTO(SupportRequest supportRequest) {
        return SupportRequestDTO.builder()
                .id(supportRequest.getId())
                .supportRequestTitle(supportRequest.getSupportRequestTitle())
                .supportRequestContent(supportRequest.getSupportRequestContent())
                .supportRequestStatus(supportRequest.getSupportRequestStatus())
                .createdDate(supportRequest.getCreatedDate())
                .updatedDate(supportRequest.getUpdatedDate())
                .memberDTO(toMemberDTO(supportRequest.getMember()))
                .supports(supportRequest.getSupports())
                .supportRequestFiles(supportRequest.getSupportRequestFiles())
                .build();
    }

    default MemberDTO toMemberDTO(Member member){
        return MemberDTO.builder()
                .id(member.getId())
                .memberRank(member.getMemberRank())
                .memberName(member.getMemberName())
                .memberVolunteerTime(member.getMemberVolunteerTime())
                .memberAddress(member.getMemberAddress())
                .memberEmail(member.getMemberEmail())
                .memberAge(member.getMemberAge())
                .memberPassword(member.getMemberPassword())
                .memberInterest(member.getMemberInterest())
                .memberJoinType(member.getMemberJoinType())
                .memberRice(member.getMemberRice())
                .memberRole(member.getMemberRole())
                .memberStatus(member.getMemberStatus())
                .build();
    }
}
