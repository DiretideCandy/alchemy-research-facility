package ru.ct.alchemy.configuration;

import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.ct.alchemy.model.mappers.ActionMapper;

@Configuration
@EnableTransactionManagement
@EnableScheduling
@AllArgsConstructor
public class SpringConfiguration implements WebMvcConfigurer {

    @Bean
    public ActionMapper actionMapper() {
        return Mappers.getMapper(ActionMapper.class);
    }

}
