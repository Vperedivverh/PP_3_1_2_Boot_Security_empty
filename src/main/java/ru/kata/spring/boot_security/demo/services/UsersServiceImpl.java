package ru.kata.spring.boot_security.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
//    @Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
@Autowired
    public UsersServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.getOne(id);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(long id, User user) {
        User user1 = userRepository.getOne(id);
        user1.setName(user.getName());
        user1.setSurname(user.getSurname());
        userRepository.save(user1);
    }
    public User getUserByName(String name){
    User user = userRepository.findByName(name);
    return user;
    }


}