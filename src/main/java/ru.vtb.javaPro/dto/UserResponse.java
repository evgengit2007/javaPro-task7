package ru.vtb.javaPro.dto;

import ru.vtb.javaPro.entity.User;

import java.util.List;

public record UserResponse(List<User> userList) {
}
