package com.example.clone_quizlet.config;

import com.example.clone_quizlet.service.LoginService;
import com.example.clone_quizlet.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration // bea 을 관리하는 어노테이션
@EnableWebSecurity // spring scurity 활성 어노테이션
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserService userService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/h2-console/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
            .csrf().disable().headers().frameOptions().disable()// h2-console 화면 사용하기 위함
            .and()
                .authorizeRequests()
                    .antMatchers("/login", "singup", "user").permitAll() // 누구나 접근 가능
                    .antMatchers("/admin").hasRole("ADMIN") // ADMIN 만 접근 가능
                    .anyRequest().authenticated() // 나머지는 권한이 있기만 하면 접근 가능
            .and()
                .formLogin() // 로그인에 대한 설정
                    .loginPage("/login") // 로그인 페이지 링크
                    .defaultSuccessUrl("/")
            .and()
                .logout()// 로그아웃 관련 설정
                    .logoutSuccessUrl("/login")// 로그아웃 성공시 연결되는 주소
                    .invalidateHttpSession(true); // 로그아웃 성공시 저장해둔 세션 날리기

//        http
//            .csrf().ignoringAntMatchers("/api/**")
//            .and()
//                .authorizeRequests()
//                .antMatchers("/", "/auth/**", "/posts/read/**", "/posts/search/**").permitAll()
//                .anyRequest().authenticated()
//            .and()
//                .formLogin()
//                    .loginPage("/auth/login")
//                    .loginProcessingUrl("/loginProc")
//                    .defaultSuccessUrl("/");


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService) // 유저 정보는 userService에서 가져온다
            .passwordEncoder(new BCryptPasswordEncoder()); // 패스워드 인코더는 passwordEncoder(BCrypt 사용)
    }

}
