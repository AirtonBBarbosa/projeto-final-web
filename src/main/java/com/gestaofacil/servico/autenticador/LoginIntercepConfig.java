package com.gestaofacil.servico.autenticador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginIntercepConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptador loginintercepador;

    @Override
    public void addInterceptors(InterceptorRegistry registry) { // excessões que não irão considerar cookie
        registry.addInterceptor(loginintercepador).excludePathPatterns(
                "/login", "/logar", "/cadastro");
    }
}