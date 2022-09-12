package com.example.clone_quizlet.service;

import com.example.clone_quizlet.repository.UserRepository;
import java.util.Optional;
import javax.swing.text.html.Option;
import lombok.extern.slf4j.Slf4j;
import com.example.clone_quizlet.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginService implements UserDetailsService {
    private UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public User loadUserByUsername(String userId) throws UsernameNotFoundException {
//        // User 정보 조회
//        Optional<User> user = userRepository.findByUserId(userId);
//
//        if(user.isPresent()) {
//            System.out.println("11111");
//            User usr = user.get();
//
//            User authUser = User.builder()
//                .id(usr.getId())
//                .userId(usr.getUserId())
//                .name(usr.getName())
//                .email(usr.getEmail())
//                .password(usr.getPassword())
//                .nickname(usr.getNickname())
//                .role(usr.getRole())
//                .build();
//
//            log.info("authUser : {}", authUser);
//            return authUser;
//        }
//        return null;
//    }

    @Override
    public User loadUserByUsername(String userId) throws UsernameNotFoundException {
        return userRepository.findByUserId(userId).orElseThrow(()-> new UsernameNotFoundException(userId));
    }

}
