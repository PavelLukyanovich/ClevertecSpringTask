package ru.clevertec.ecl.service.user;

import ru.clevertec.ecl.model.dtos.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getUsers();

    UserDto getUserById(Long id);
}
