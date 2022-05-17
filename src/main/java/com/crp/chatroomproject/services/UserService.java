package com.crp.chatroomproject.services;

import com.crp.chatroomproject.models.User;
import com.crp.chatroomproject.models.UserLogin;
import com.crp.chatroomproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) throws Exception {
        userRepository.save(user);
    }

    public User verifyUser(UserLogin userLogin) throws Exception {
        User user = userRepository.findByUserNameAndPassword(userLogin.getUserName(), userLogin.getPassword());
        if (user == null) {
            throw new Exception("Username or password incorrect");
        }return user;
    }

    public User getUserById(Long userId) throws Exception{
        return this.userRepository.findById(userId).orElseThrow();
    }
}
