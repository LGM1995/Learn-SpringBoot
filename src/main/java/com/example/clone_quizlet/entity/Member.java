package com.example.clone_quizlet.entity;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
public class Member {

    @Id // 대표 값 회원 번호
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 회원 id
    @Column
    private String name; // 회원 이름
    @Column
    private String email; // 회원 이메일
    @Column
    private String password; // 회원 비밀번호
    @Column
    private String nickname; // 회원 별명

//    @OneToMany(mappedBy = "member")
//    private List<Note> notes = new ArrayList<>();
    /* @Column
    private String photo; // 회원 사진
    @Column
    private Time birthday; // 회원 생일 */

    public void patch(Member member) {
        if (member.password != null)
            this.password = member.password;
        if (member.nickname != null)
            this.nickname = member.nickname;
//        if (member.photo != null)
//            this.photo = member.photo;
//        if (member.birthday != null)
//            this.birthday = member.birthday;
    }
}
