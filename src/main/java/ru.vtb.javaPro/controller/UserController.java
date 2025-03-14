package ru.vtb.javaPro.controller;

import org.springframework.web.bind.annotation.*;
import ru.vtb.javaPro.dto.UserResponse;
import ru.vtb.javaPro.service.UserService;
import java.util.Collections;

@RestController
@RequestMapping(value = "/v1/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // http://localhost:8989/products/v1/api/users/user/1
    @RequestMapping("/user/{uid}")
    public UserResponse findUserById(@PathVariable Long uid) {
        return new UserResponse(Collections.singletonList(userService.findUserById(uid)));
    }

}
