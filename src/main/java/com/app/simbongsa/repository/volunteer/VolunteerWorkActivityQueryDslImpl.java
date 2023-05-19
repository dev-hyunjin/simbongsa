package com.app.simbongsa.repository.volunteer;

import com.app.simbongsa.entity.volunteer.QVolunteerWork;
import com.app.simbongsa.entity.volunteer.QVolunteerWorkActivity;
import com.app.simbongsa.entity.volunteer.VolunteerWorkActivity;
import com.app.simbongsa.provider.UserDetail;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static com.app.simbongsa.entity.volunteer.QVolunteerWork.volunteerWork;
import static com.app.simbongsa.entity.volunteer.QVolunteerWorkActivity.volunteerWorkActivity;

@RequiredArgsConstructor
public class VolunteerWorkActivityQueryDslImpl implements VolunteerWorkActivityQueryDsl {
    private final JPAQueryFactory query;

//    신청 명단 조회
    @Override
    public List<VolunteerWorkActivity> findApplyByVolunteerWorkId(Long id) {
        return query.select(volunteerWorkActivity)
                .from(volunteerWorkActivity)
                .where(volunteerWorkActivity.volunteerWork.id.eq(id))
                .join(volunteerWorkActivity.member)
                .fetchJoin()
                .fetch();
    }

    /* 내 봉사 활동 목록 조회(페이징처리) */
    @Override
    public Page<VolunteerWorkActivity> findMyVolunteerById(Pageable pageable, UserDetail userDetail) {
        List<VolunteerWorkActivity> foundVolunteerWorkActivities = query.select(volunteerWorkActivity)
                .from(volunteerWorkActivity)
                .join(volunteerWorkActivity.volunteerWork)
                .fetchJoin()
                .where(volunteerWorkActivity.member.id.eq(userDetail.getMember().getId()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long count = query.select(volunteerWorkActivity.count())
                .from(volunteerWorkActivity)
                .where(volunteerWorkActivity.member.id.eq(userDetail.getMember().getId()))
                .fetchOne();

        return new PageImpl<>(foundVolunteerWorkActivities,pageable,count);
    }



}
