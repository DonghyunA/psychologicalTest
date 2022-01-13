package com.sinbo.psychologicalTest.service.user;

import com.sinbo.psychologicalTest.entity.user.User;
import com.sinbo.psychologicalTest.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User findbyId(long userId){
        return userRepository.findById(userId);
    }
}
