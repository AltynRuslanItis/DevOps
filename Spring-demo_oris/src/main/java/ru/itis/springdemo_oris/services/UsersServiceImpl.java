package ru.itis.springdemo_oris.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springdemo_oris.dto.UserDto;
import ru.itis.springdemo_oris.repository.UsersRepository;

import java.util.List;

import static ru.itis.springdemo_oris.dto.UserDto.usersList;

@Component
public class UsersServiceImpl implements UsersServices{

    @Autowired
    private UsersRepository usersRepository;
    
    @Override
    public List<UserDto> getAllUsers() {
        return usersList(usersRepository.findAll());
    }
}
