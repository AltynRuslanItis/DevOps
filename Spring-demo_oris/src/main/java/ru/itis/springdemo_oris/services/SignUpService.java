package ru.itis.springdemo_oris.services;

import ru.itis.springdemo_oris.dto.UserForm;

public interface SignUpService {
    void addUser(UserForm userForm);
}