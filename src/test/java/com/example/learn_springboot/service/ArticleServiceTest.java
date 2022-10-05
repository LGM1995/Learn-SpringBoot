package com.example.learn_springboot.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.learn_springboot.dto.ArticleForm;
import com.example.learn_springboot.entity.Article;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // 해당 클래스는 스트링부트와 연동되어 테스팅된다
class ArticleServiceTest {

    @Autowired ArticleService articleService;

    @Test
    void index() {
        // 예상
        Article a = new Article(1L, "가가가가", "1111");
        Article b = new Article(2L, "나나나나", "2222");
        Article c = new Article(3L, "다다다다", "3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));


        // 실제
        List<Article> articles = articleService.index();

        // 비교
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void show_성공____존재하는_id_입력() {
        // 예상
        Long id = 1L;
        Article expected = new Article(id, "가가가가", "1111");

        // 실제
        Article article = articleService.show(id);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void show_실패____존재하지_않는_id_입력() {
        // 예상
        Long id = -1L;
        Article expected = null;

        // 실제
        Article article = articleService.show(id);

        // 비교
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void create_성공____title과_content만_있는_dto_입력() {
        // 예상
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);

        // 실제
        Article article = articleService.create(dto);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void create_실패____id가_포함된_dto_입력() {
        // 예상
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(4L, title, content);
        Article expected = null;

        // 실제
        Article article = articleService.create(dto);

        // 비교
        assertEquals(expected, article);
    }


    @Test
    @Transactional
    void update_성공____존재하는_id와_title_content가_있는_dto_입력() {
        // 예상
        Long id = 1L;
        String title = "이게 맞나?";
        String content = "요시~";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = new Article(1L, title, content);

        // 실제
        Article article = articleService.update(id, dto);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void update_성공____존재하는_id와_title만_있는_dto_입력() {
        // 예상
        Long id = 1L;
        String title = "이게 맞나?";
        ArticleForm dto = new ArticleForm(id, title, null);
        Article expected = new Article(1L, title, null);

        // 실제
        Article article = articleService.update(id, dto);

        // 비교
        assertEquals(expected.toString(), article.toString());
        System.out.println(expected.toString());
        System.out.println(article.toString());
    }

    @Test
    @Transactional
    void update_성공2____title_빠져도_됨() {
        // 예상
        Long id = 1L;
        String title = null;
        String content = "1234";
        ArticleForm dto = new ArticleForm(id, title, content);

        // 실제
        Article article = articleService.update(id, dto);

        // 예상
        Article expected = new Article(id, "가가가가", content);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void update_실패____존재하지_않는_id와_dto_입력() {
        // 예상
        Long id = -1L;
        String title = "이게 맞나?";
        String content = "요오오오시";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;

        // 실제
        Article article = articleService.update(id, dto);

        // 비교
        assertEquals(expected, article);
    }

//    @Test
//    @Transactional
//    void update_실패____id만_있는_dto_입력() {
//        // 준비
//        Long id = 1L;
//        ArticleForm dto = new ArticleForm(id, null,null);
//
//        // 예상 update에 실패하였기 때문에 값이 변하지 않을것이다.
//        Article expected = articleService.show(id);
//
//        // 실제
//        Article article = articleService.update(id, dto);
//
//        // 비교
//        assertEquals(expected.toString(), article.toString());
//
//    }

    @Test
    @Transactional
    void delete_성공____존재하는_id_입력() {
        // 예상
        Long id = 1L;
        Article expected = null;

        // 실제
        Article article = articleService.delete(id);
        article  = articleService.show(id);
        // DB에서는 삭제되었으나 서비스객체의 타겟은 그대로 정보가 남아있어
        // DB에서 다시 해당 아이디의 값을 조회해야한다.

        // 비교
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void delete_실패____존재하지_않는_id_입력() {
        // 예상
        Long id = -1L;
        Article expected = null;

        // 실제
        Article article = articleService.delete(id);

        // 비교
        assertEquals(expected, article);
    }
}