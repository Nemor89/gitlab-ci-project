package com.ws.gitlab.local;

import org.springframework.boot.SpringApplication;

public class TestGitlabCiApplication {

    public static void main(String[] args) {
        SpringApplication.from(GitlabCiApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
