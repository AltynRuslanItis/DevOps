package ru.itis.springdemo_oris.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.springdemo_oris.dto.UserForm;
import ru.itis.springdemo_oris.models.Role;
import ru.itis.springdemo_oris.models.State;
import ru.itis.springdemo_oris.models.User;
import ru.itis.springdemo_oris.repository.UsersRepository;

import java.util.UUID;


@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void addUser(UserForm userForm) {
        User user = User.builder()
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .firstName(userForm.getFirstname())
                .lastName(userForm.getLastname())
                .state(State.CONFIRMED)
                .role(Role.USER)
                .confirmCode(UUID.randomUUID().toString())
                .build();
        usersRepository.save(user);

    }
}
