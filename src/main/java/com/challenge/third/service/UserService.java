package com.challenge.third.service;

import com.challenge.third.model.User;
import com.challenge.third.repository.UserRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ArrayList<User> findAll() {
        return (ArrayList<User>) userRepository.findAll();
    }

    public User save(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception exception) {
            return null;
        }
    }

    public User login(String nickname, String password) {
        User user = userRepository.findByNickname(nickname);
        if (user != null && user.checkPassword(password)) {
            return user;
        }
        return null;
    }
    
}
