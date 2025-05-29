package com.gestaofacil.servico.autenticador;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.gestaofacil.servico.CookieServico;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptador implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        if (CookieServico.getCookie(request, "usuarioId") != null) {
            return true;
        }

        response.sendRedirect("/login");
        return false;

    }

}
