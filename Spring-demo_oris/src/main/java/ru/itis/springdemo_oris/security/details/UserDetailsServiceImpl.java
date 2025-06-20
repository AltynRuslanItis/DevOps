package ru.itis.springdemo_oris.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.itis.springdemo_oris.models.User;
import ru.itis.springdemo_oris.repository.UsersRepository;

import java.util.Optional;

@Component("customUserDetailService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = usersRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User is not found"));
        return new UserDetailsImpl(user);
    }
}
