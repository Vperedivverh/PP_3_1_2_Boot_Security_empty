package ru.kata.spring.boot_security.demo.services;




import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;
@Service

public interface UsersService {
    List<User> getAllUsers();

    User getUserById(long id);

    void saveUser(User user);

    void deleteById(long id);

    void updateUser(long id, User user);
}