package ru.job4j.forum.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.RoleRepository;
import ru.job4j.forum.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final RoleRepository roles;

    public UserService(UserRepository userRepository, PasswordEncoder encoder, RoleRepository roles) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.roles = roles;
    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElse(new User());
    }

    public boolean userVerification(String username) {
        return userRepository.findByUsername(username) == null;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public void createUser(User user) {
        user.setEnable(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setPassword(user.getPassword());
        user.addRole(roles.findByName("ROLE_USER"));
        userRepository.save(user);
    }
}
