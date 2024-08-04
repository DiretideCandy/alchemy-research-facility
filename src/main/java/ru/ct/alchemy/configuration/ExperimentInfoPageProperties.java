package ru.ct.alchemy.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "experiment.defaults")
@Getter
@Setter
public class ExperimentInfoPageProperties {
    private String unknown;
}
