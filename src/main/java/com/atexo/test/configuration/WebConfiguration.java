package com.atexo.test.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages= {"com.atexo.test"})
@PropertySource("classpath:cards.properties")
public class WebConfiguration implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hand").setViewName("hand");
        registry.addViewController("/").setViewName("menu");
        registry.addViewController("/orderHand").setViewName("orderHand");
    }
}