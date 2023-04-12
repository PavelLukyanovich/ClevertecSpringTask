package ru.clevertec.ecl.service.user;

import ru.clevertec.ecl.model.dtos.UserDto;
import ru.clevertec.ecl.model.entities.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    UserDto getUserById(Long id);
}
