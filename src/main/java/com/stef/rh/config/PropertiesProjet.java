package com.stef.rh.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:proprieties.yml")
@ConfigurationProperties(prefix = "project")
@Getter
@Setter
@NoArgsConstructor
public class PropertiesProjet {
    private String nom;
    private String libelle;
}
