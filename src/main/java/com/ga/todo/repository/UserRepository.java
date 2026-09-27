package com.ga.todo.repository;

import com.ga.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmailAddress(String email);

    User findUserByEmailAddress(String email);
}
