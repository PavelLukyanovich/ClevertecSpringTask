package ru.clevertec.ecl.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.ecl.model.dtos.UserDto;
import ru.clevertec.ecl.service.user.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public List<UserDto> getUsers(@RequestParam(required = false, defaultValue = "0") int page,
                                  @RequestParam(required = false, defaultValue = "2") int size) {

        return userService.getUsers(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {

        return userService.getUserById(id);
    }

}
