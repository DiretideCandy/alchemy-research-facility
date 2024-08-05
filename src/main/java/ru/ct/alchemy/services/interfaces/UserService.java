package ru.ct.alchemy.services.interfaces;

import ru.ct.alchemy.model.security.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
