package com.example.clone_quizlet.service;

import com.example.clone_quizlet.dto.ArticleForm;
import com.example.clone_quizlet.dto.MemberForm;
import com.example.clone_quizlet.entity.Article;
import com.example.clone_quizlet.entity.Member;
import com.example.clone_quizlet.repository.MemberRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> index() { return memberRepository.findAll(); }

    public Member show(Long id) { return memberRepository.findById(id).orElse(null);}

    public Member create(MemberForm dto) {
        Member member = dto.toEntity();
        if (member.getId() != null) {
            return null;
        }
        return memberRepository.save(member);
    }

    public Member update(Long id, MemberForm dto) {
        // 1 : 수정용 엔티티 생성
        Member member = dto.toEntity();
        log.info("id: {}, member: {}", id, member.toString());

        // 2 : 대상 엔티티 찾기
        Member targer = memberRepository.findById(id).orElse(null);

        // 3 : 잘못된 요청 처리(대상이 없거나, 회원번호가 다른 경우)
        if (targer == null || id != member.getId()) {
            log.info("잘못된 요청! id: {}, member: {}", id, member.toString());
            return  null;
        }

        // 4 : 업데이트
        targer.patch(member);
        Member updated = memberRepository.save(targer);
        return updated;
    }

    public Member delete(Long id) {
        // 대상 찾기
        Member target = memberRepository.findById(id).orElse(null);

        // 잘못된 요청 처리
        if (target == null) {
            return null;
        }

        // 대상 삭제
        memberRepository.delete(target);
        return target;
    }

    @Transactional
    public List<Member> createMember(List<MemberForm> dtos) {
        // dto 묶음을 entity 묶음으로 변환
        List<Member> memberList = dtos.stream()
            .map(dto -> dto.toEntity())
            .collect(Collectors.toList());

        // entity 묶음을 DB로 저장
        memberList.stream()
            .forEach(article -> memberRepository.save(article));

        // 강제 에외 발생
        memberRepository.findById(-1L).orElseThrow(
            () -> new IllegalArgumentException("결제 실패!")
        );

        // 결과값 반환
        return memberList;
    }
}
