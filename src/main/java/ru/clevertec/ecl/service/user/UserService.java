package ru.clevertec.ecl.service.user;

import org.springframework.data.domain.PageRequest;
import ru.clevertec.ecl.model.dtos.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getUsers(PageRequest of);

    UserDto getUserById(Long id);
}
