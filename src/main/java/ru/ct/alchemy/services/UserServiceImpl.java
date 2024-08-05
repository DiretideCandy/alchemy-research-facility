package ru.ct.alchemy.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ct.alchemy.model.security.Role;
import ru.ct.alchemy.model.security.User;
import ru.ct.alchemy.repositories.UserRepository;
import ru.ct.alchemy.services.interfaces.UserService;

import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void save(User user, Set<Role> roles) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }
}
