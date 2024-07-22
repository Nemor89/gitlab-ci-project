package com.ws.gitlab.gitlabci;

import org.springframework.boot.SpringApplication;

public class TestGitlabCiApplication {

    public static void main(String[] args) {
        SpringApplication.from(GitlabCiApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
