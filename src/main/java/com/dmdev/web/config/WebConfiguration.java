package com.dmdev.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("web|prod")
@Configuration
public class WebConfiguration {
}
