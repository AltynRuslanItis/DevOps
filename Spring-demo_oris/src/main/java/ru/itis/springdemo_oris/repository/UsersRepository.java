package ru.itis.springdemo_oris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springdemo_oris.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByConfirmCode(String code);
}
