package com.sinbo.psychologicalTest.repo;

import com.sinbo.psychologicalTest.entity.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByUsr(String user);

    User findById(long id);
}
