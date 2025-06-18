package ru.itis.springdemo_oris.services;

import ru.itis.springdemo_oris.dto.UserDto;

import java.util.List;

public interface UsersServices {
    List<UserDto> getAllUsers();
}
