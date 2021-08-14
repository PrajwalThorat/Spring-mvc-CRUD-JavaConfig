package org.stackroute.cofig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "org.stackroute")
@EnableWebMvc

public class WebConfig {
	
	@Bean
	public ViewResolver resolver() {
		return new InternalResourceViewResolver("/WEB-INF/" , ".jsp");
	}
	
}
