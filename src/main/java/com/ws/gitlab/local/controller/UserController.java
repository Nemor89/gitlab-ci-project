package com.ws.gitlab.local.controller;

import com.ws.gitlab.local.entity.User;
import com.ws.gitlab.local.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping(value = "/get/all")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/get/{name}")
    public User getByName(@PathVariable(value = "name") String name) {
        return userRepository.findByName(name).orElse(null);
    }

    @GetMapping(value = "/get/constant/ivan")
    public User getIvan() {
        return userRepository.findByName("ivan").orElse(null);
    }
}
