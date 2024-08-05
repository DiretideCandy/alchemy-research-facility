package ru.ct.alchemy.presentation.initdata.initializers;

import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.presentation.initdata.Initializer;
import ru.ct.alchemy.presentation.initdata.PresentationData;
import ru.ct.alchemy.repositories.RoleRepository;

@Component
@AllArgsConstructor
@Order(7)
public class InitializerRoles implements Initializer {

    private final PresentationData presentationData;
    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public void create(){
        roleRepository.saveAll(presentationData.getRoles());
    }
}
