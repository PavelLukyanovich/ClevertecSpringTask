package ru.clevertec.ecl.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.clevertec.ecl.model.dtos.UserDto;
import ru.clevertec.ecl.model.entities.User;
import ru.clevertec.ecl.repository.user.UserRepository;
import ru.clevertec.ecl.utils.mapper.UserMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDto> getUsers(PageRequest of) {

        List<User> users = userRepository.findAll();
        List<UserDto> usersDto = users.stream()
                .map(UserMapper.INSTANCE::userToUserDto)
                .toList();

        return usersDto;
    }

    @Override
    public UserDto getUserById(Long id) {

        User user = userRepository.getReferenceById(id);
        UserDto userDto = UserMapper.INSTANCE.userToUserDto(user);

        return userDto;
    }
}
