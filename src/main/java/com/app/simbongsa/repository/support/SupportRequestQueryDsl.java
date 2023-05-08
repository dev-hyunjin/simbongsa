package com.app.simbongsa.repository.support;

import com.app.simbongsa.domain.search.admin.AdminSupportRequestSearch;
import com.app.simbongsa.entity.support.SupportRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface SupportRequestQueryDsl {
    /* 유저별 후원 요청 조회 */
    public Page<SupportRequest> findByUserId(Pageable pageable, Long id);
    // 후원 요청 목록
    public Slice<SupportRequest> findAllSupportRequest(Pageable pageable);
    // 후원 요청 전체 조회
    public Page<SupportRequest> findAllWithPaging(AdminSupportRequestSearch adminSupportRequestSearch, Pageable pageable);

}
