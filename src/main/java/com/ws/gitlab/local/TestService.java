package com.ws.gitlab.local;

import com.ws.gitlab.local.entity.User;
import com.ws.gitlab.local.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestService {

    private final UserRepository userRepository;

    public User getPetr() {
        return userRepository.findByName("petr").orElse(null);
    }
}
