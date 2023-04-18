package ru.clevertec.ecl.service.user;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import ru.clevertec.ecl.model.dtos.UserDto;
import ru.clevertec.ecl.model.entities.Order;
import ru.clevertec.ecl.model.entities.User;
import ru.clevertec.ecl.repository.user.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void whenGetUsers_shouldReturnCorrectQuantityOfUsers() {

        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Any", "Many", List.of(new Order())));
        users.add(new User(2L, "Any", "Many", List.of(new Order())));

        when(userRepository.findAll()).thenReturn(users);

        List<UserDto> usersDto = userService.getUsers(PageRequest.of(0, 10));

        assertEquals(users.size(), usersDto.size());
    }

    @Test
    public void whenGetUserById_shouldReturnCorrectUser() {

        User user = new User(1L, "Any", "Many", List.of(new Order()));

        when(userRepository.getReferenceById(1L)).thenReturn(user);

        UserDto userDto = userService.getUserById(1L);

        assertEquals(user.getId(), userDto.getId());
        assertEquals(user.getFirstName(), userDto.getFirstName());
        assertEquals(user.getLastName(), userDto.getLastName());
    }

}