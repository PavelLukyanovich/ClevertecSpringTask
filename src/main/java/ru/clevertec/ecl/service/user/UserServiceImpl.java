package ru.clevertec.ecl.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clevertec.ecl.model.dtos.UserDto;
import ru.clevertec.ecl.model.entities.User;
import ru.clevertec.ecl.repository.user.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDto getUserById(Long id) {
        return null;
    }
}
