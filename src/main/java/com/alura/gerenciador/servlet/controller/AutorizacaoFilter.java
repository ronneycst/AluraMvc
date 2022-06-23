package com.alura.gerenciador.servlet.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/entrada")
public class AutorizacaoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String param = req.getParameter("acao");
        boolean autentica = !(param.equals("FormLogin") || param.equals("Login"));

        System.out.println("entrou no AF filter");

        if(autentica && req.getSession().getAttribute("usuarioLogado") == null){
            resp.sendRedirect("entrada?acao=FormLogin");
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
