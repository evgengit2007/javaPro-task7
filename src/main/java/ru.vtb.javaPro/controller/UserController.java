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

    @PostMapping("/user")
//    @GetMapping("/user")
    public UserResponse findUserById(@RequestParam("id") Long id) {
        System.out.println("id = " + id);
        return new UserResponse(Collections.singletonList(userService.findUserById(id)));
    }

}
