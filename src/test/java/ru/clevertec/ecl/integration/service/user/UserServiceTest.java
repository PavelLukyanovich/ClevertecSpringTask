package ru.clevertec.ecl.integration.service.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import ru.clevertec.ecl.integration.BaseTest;
import ru.clevertec.ecl.model.dtos.UserDto;
import ru.clevertec.ecl.service.user.UserService;

import java.util.List;

public class UserServiceTest extends BaseTest {
    @Autowired
    private UserService userService;

    @Test
    void whenGetUsers_ShouldReturn3() {

        int expectedUsersCount = 3;

        List<UserDto> actualUsers = userService.getUsers(PageRequest.of(1, 5));
        Assertions.assertThat(actualUsers).hasSize(expectedUsersCount);
    }

    @Test
    void whenGetUserById_shouldReturnUserWithCurrentId() {

        Long expectedId = 3L;

        UserDto actualUser = userService.getUserById(expectedId);

        Assertions.assertThat(actualUser.getId()).isEqualTo(expectedId);
    }
}

