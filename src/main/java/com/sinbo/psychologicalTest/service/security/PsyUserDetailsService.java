package com.sinbo.psychologicalTest.service.security;

import com.sinbo.psychologicalTest.entity.user.User;
import com.sinbo.psychologicalTest.repo.UserRepository;
  import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PsyUserDetailsService implements UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // todo 예외처리필요
        return userRepository.findByEmail(email);
    }

}


