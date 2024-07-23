package com.ws.gitlab.local;

import com.ws.gitlab.local.entity.User;
import com.ws.gitlab.local.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CiTest {

    @MockBean
    UserRepository userRepo;

    @Test
    public void test() {
        when(userRepo.findAll()).thenReturn(List.of(new User()));

        List<User> users = userRepo.findAll();

        assertThat(users).size().isEqualTo(1);
    }
}
