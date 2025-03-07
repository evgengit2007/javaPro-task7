package ru.vtb.javaPro.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.vtb.javaPro.entity.User;
import ru.vtb.javaPro.repository.UserRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findUserById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public User findUserByName(String name) {
        return userRepository.findUserByUsername(name).orElseThrow(EntityNotFoundException::new);
    }

    public User insertUser(String name) {
        User user = new User();
        user.setUsername(name);
        userRepository.save(user);
        return findUserByName(name);
    }

    public User updateUsernameById(Long id, String name) {
        User user = findUserById(id);
        user.setUsername(name);
        userRepository.save(user);
        return user;
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

}

