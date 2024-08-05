package ru.ct.alchemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ct.alchemy.model.security.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
