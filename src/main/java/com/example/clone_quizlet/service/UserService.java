package com.example.clone_quizlet.service;

import com.example.clone_quizlet.dto.UserDto;
import com.example.clone_quizlet.entity.User;
import com.example.clone_quizlet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public User loadUserByUsername(String userId) throws UsernameNotFoundException {
        return userRepository.findByUserId(userId)
            .orElseThrow(() -> new UsernameNotFoundException(userId));
    }

    public Long save(UserDto userDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userDto.setPassword(encoder.encode(userDto.getPassword()));

        return userRepository.save(User.builder()
            .userId(userDto.getUserId())
            .role(userDto.getRole())
            .password(userDto.getPassword()).build()).getId();
    }
}
