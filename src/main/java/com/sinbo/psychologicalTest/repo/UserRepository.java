package com.sinbo.psychologicalTest.repo;

import com.sinbo.psychologicalTest.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByUser(String user);

    User findById(long id);
}
