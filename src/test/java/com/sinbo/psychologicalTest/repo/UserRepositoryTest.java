package com.sinbo.psychologicalTest.repo;

import com.sinbo.psychologicalTest.entity.user.User;
import com.sinbo.psychologicalTest.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void userRepoTest(){
        User usr = userRepository.findById(0);
        assertNotNull(usr);
    }

}
