package com.ws.gitlab.local.repository;

import com.ws.gitlab.local.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from users u where lower(u.name) = lower(:name)")
    Optional<User> findByName(@Param("name") String name);
}
