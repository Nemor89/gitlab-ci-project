package com.ws.gitlab.local.config;

import com.ws.gitlab.local.entity.User;
import com.ws.gitlab.local.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) {
        Set<User> users = Stream.of("Ivan", "Sergey", "Petr")
                .map(name -> {
                    User user = new User();
                    user.setName(name);

                    return user;
                })
                .collect(Collectors.toSet());

        userRepository.saveAll(users);
    }
}
