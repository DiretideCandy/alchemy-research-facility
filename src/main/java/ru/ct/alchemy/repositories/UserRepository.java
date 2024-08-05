package ru.ct.alchemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ct.alchemy.model.security.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String name);
}
