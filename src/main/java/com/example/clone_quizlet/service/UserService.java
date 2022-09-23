package com.example.clone_quizlet.service;

import com.example.clone_quizlet.dto.UserDto;
import com.example.clone_quizlet.entity.User;
import com.example.clone_quizlet.repository.UserRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 유저 전체 리스트를 가져옴
    public List<User> index() { return userRepository.findAll();}
    // 유저 고유 번호로 검색
    public User show(Long id) { return userRepository.findById(id).orElse(null);}
    // 유저 생성
    public User create(UserDto userDto) {
        User user = userDto.toEntity();
        if (user.getId() != null) {
            return null;
        }
        return userRepository.save(user);
    }

    public User update(Long id, UserDto userDto) {
        User user = userDto.toEntity();

        User target = userRepository.findById(id).orElse(null);

        if (target == null || id != user.getId()) {
            return null;
        }
        target.patch(user);
        User updated = userRepository.save(target);
        return updated;
    }

    public User delete(Long id) {
        User target = userRepository.findById(id).orElse(null);
        if (target == null) {
            return null;
        }
        userRepository.delete(target);
        return target;
    }
}
