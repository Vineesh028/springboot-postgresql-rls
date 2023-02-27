package com.postgres.rls.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebConfiguration implements WebMvcConfigurer {

	@Autowired
	private TenantInterceptor tenantInterceptor;

	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
		registry.addInterceptor(tenantInterceptor);
	}

	@Override
	public void addCorsMappings(final CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
				.allowedOrigins("*").allowedHeaders("*");
	}
	
	@Bean
	public ModelMapper modelMapper() {

		return new ModelMapper();
	}
}