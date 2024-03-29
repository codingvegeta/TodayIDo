package com.example.corespringsecurity.config;

import com.example.corespringsecurity.repository.AccessIpRepository;
import com.example.corespringsecurity.repository.ResourcesRepository;
import com.example.corespringsecurity.service.SecurityResourceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public SecurityResourceService securityResourceService(ResourcesRepository resourcesRepository, AccessIpRepository accessIpRepository) {
        SecurityResourceService securityResourceService = new SecurityResourceService(resourcesRepository, accessIpRepository);
        return securityResourceService;
    }
}
