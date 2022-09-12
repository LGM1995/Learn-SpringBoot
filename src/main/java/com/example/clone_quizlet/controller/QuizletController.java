package com.example.clone_quizlet.controller;

import com.example.clone_quizlet.dto.ArticleForm;
import com.example.clone_quizlet.dto.CommentDto;
import com.example.clone_quizlet.dto.MemberForm;
import com.example.clone_quizlet.dto.NoteDto;
import com.example.clone_quizlet.entity.Article;
import com.example.clone_quizlet.entity.Member;
import com.example.clone_quizlet.repository.MemberRepository;
import com.example.clone_quizlet.service.NoteService;
import com.example.clone_quizlet.service.WordService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.resource.beans.container.internal.NotYetReadyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class QuizletController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private NoteService noteService;

    @Autowired
    private WordService wordService;

    @GetMapping("/quizlet/new")
    public String newMemberFrom() { return "quizlet/new"; }

    @PostMapping("/quizlet/create")
    public String createMembers(MemberForm form) {
        log.info(form.toString());
        // System.out.println(form.toString()); -> 로깅기능으로 대체!

        // 1. Dto를 변환! Entity!
        Member member = form.toEntity();
        log.info(member.toString());
        // System.out.println(article.toString());

        // 2. Repository에게 Entity를 DB안에 저장하게 함!
        Member saved = memberRepository.save(member);
        log.info(saved.toString());
        // System.out.println(saved.toString());

        return "redirect:/quizlet/" + saved.getId();
    }

    @GetMapping("/quizlet/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);

        // 1: id로 데이터 가져오기
        Member memberEntity = memberRepository.findById(id).orElse(null);
        List<NoteDto> noteDtos = noteService.notes(id);

        // 2: 가져온 데이터를 모델에 등록!
        model.addAttribute("member", memberEntity);
        model.addAttribute("noteDtos", noteDtos);

        // 3: 보여줄 페이지를 설정!
        return "quizlet/show";
    }

    @RequestMapping("/quizlet")
    public String home() {
        return "quizlet/home";
    }

    @GetMapping("/quizlet/login")
    public String login() {
        return "quizlet/login";
    }

//    @GetMapping("/quizlet")
//    public String index(Model model) {
//        // 1: 모든 Member를 가져온다!
//        ArrayList<Member> memberEntityList = memberRepository.findAll();
//
//        // 2: 가져온 Member 묶음을 뷰로 전달!
//        model.addAttribute("memberList", memberEntityList);
//
//        // 3: 뷰 페이지를 설정
//        return "quizlet/index";
//    }

    @GetMapping("quizlet/{id}/edit")
    public String edit(@PathVariable  Long id, Model model) {
        // 수정할 데이터를 가져오기!
        Member memberEntity = memberRepository.findById(id).orElse(null);

        // 모델에 데이터를 등록!
        model.addAttribute("member", memberEntity);

        // 뷰 페이지 설정
        return "quizlet/edit";
    }

    @PostMapping("/quizlet/update")
    public String update(MemberForm form) {
        log.info(form.toString());

        // 1: DTO를 엔티티로 변환한다!
        Member memberEntitiy = form.toEntity();
        log.info(memberEntitiy.toString());

        // 2: 엔티티를 DB로 저장한다!
        // 2-1: DB에서 기존 데이터를 가져온다!
        Member target = memberRepository.findById(memberEntitiy.getId()).orElse(null);
        // 2-2: 기존 데이터가 있다면 값을 갱신한다!
        if (target != null) {
            memberRepository.save(memberEntitiy); // 엔티티가 DB로 갱신!
        }

        // 3: 수정 결과 페이지로 리다이렉트 한다!
        return "redirect:/quizlet/" + memberEntitiy.getId();
    }

    @GetMapping("/quizlet/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {
        log.info("삭제 요청이 들어왔습니다!");

        // 1: 삭제 대상을 가져온다!
        Member target = memberRepository.findById(id).orElse(null);
        log.info(target.toString());

        // 2: 대상을 삭제 한다!
        if (target != null) {
            memberRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제가 완료되었습니다.");
        }

        // 3: 결과 페이지로 리다이렉트 한다!
        return "redirect:/quizlet";
    }
}
