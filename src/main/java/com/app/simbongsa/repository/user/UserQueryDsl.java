package com.app.simbongsa.repository.user;

import com.app.simbongsa.domain.search.admin.AdminUserSearch;
import com.app.simbongsa.entity.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserQueryDsl {

//    회원 전체 조회(페이징)
    public Page<User> findAllWithPaging(AdminUserSearch adminUserSearch, Pageable pageable);

//    회원 정보 수정
    public void updateUser(Long id, String userName, String userAddress, String userInterest, int userVolunteerTime);

//   회원 랭킹 조회
    public List<User> findUserWithVolunteerTime();
}
