package ru.ct.alchemy.presentation.initdata.initializers;

import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.model.security.User;
import ru.ct.alchemy.presentation.initdata.Initializer;
import ru.ct.alchemy.repositories.RoleRepository;
import ru.ct.alchemy.services.interfaces.UserService;

import java.util.Set;

@Component
@AllArgsConstructor
@Order(7)
public class InitializerUsers implements Initializer {

    private final RoleRepository roleRepository;
    private final UserService userService;

    @Override
    @Transactional
    public void create(){
        userService.save(
                User.builder()
                        .userName("admin")
                        .password("admin")
                        .build(),
                Set.of(
                        roleRepository.findByName("SYSTEM_ADMIN"),
                        roleRepository.findByName("SCIENTIST"),
                        roleRepository.findByName("MANAGER"),
                        roleRepository.findByName("API")));

        userService.save(
                User.builder()
                        .userName("scientist")
                        .password("scientist")
                        .build(),
                Set.of(
                        roleRepository.findByName("SCIENTIST")));

        userService.save(
                User.builder()
                        .userName("manager")
                        .password("manager")
                        .build(),
                Set.of(
                        roleRepository.findByName("MANAGER")));

        userService.save(
                User.builder()
                        .userName("apprentice")
                        .password("apprentice")
                        .build(),
                Set.of(
                        roleRepository.findByName("API")));
    }
}
