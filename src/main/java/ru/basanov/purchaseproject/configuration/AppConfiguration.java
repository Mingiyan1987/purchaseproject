package ru.basanov.purchaseproject.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableAutoConfiguration
@Configuration
@ComponentScan("ru.basanov.purchaseproject")
public class AppConfiguration implements WebMvcConfigurer {
}
