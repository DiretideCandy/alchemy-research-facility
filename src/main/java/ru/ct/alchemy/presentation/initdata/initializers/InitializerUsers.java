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
                        .roles(Set.of(
                                roleRepository.findByName("SYSTEM_ADMIN"),
                                roleRepository.findByName("SCIENTIST"),
                                roleRepository.findByName("MANAGER"),
                                roleRepository.findByName("API")))
                        .build());

        userService.save(
                User.builder()
                        .userName("scientist")
                        .password("scientist")
                        .roles(Set.of(
                                roleRepository.findByName("SCIENTIST")))
                        .build());

        userService.save(
                User.builder()
                        .userName("manager")
                        .password("manager")
                        .roles(Set.of(
                                roleRepository.findByName("MANAGER")))
                        .build());

        userService.save(
                User.builder()
                        .userName("apprentice")
                        .password("apprentice")
                        .roles(Set.of(
                                roleRepository.findByName("API")))
                        .build());
    }
}
