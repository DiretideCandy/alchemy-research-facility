package ru.ct.alchemy.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ExtraPropertiesHolder {

    @Value("${experiment.defaults.unknown}")
    private String unknown;

    @Value("${spring.jpa.hibernate.init-presentation-data}")
    private Boolean initPresentationData;

}
