package ru.ct.alchemy.configuration;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableTransactionManagement
@EnableScheduling
@AllArgsConstructor
@EnableConfigurationProperties(ExperimentInfoPageProperties.class)
public class SpringConfiguration implements WebMvcConfigurer {

}
