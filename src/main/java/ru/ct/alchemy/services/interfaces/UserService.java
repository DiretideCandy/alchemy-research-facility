package ru.ct.alchemy.services.interfaces;

import ru.ct.alchemy.model.security.Role;
import ru.ct.alchemy.model.security.User;

import java.util.Set;

public interface UserService {
    void save(User user, Set<Role> roles);

    User findByUsername(String username);
}
