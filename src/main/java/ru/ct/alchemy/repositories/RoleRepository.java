package ru.ct.alchemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ct.alchemy.model.security.Role;
import ru.ct.alchemy.model.security.User;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);

    List<Role> findAllByUsers(User user);
}
