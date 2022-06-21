package com.alura.gerenciador.servlet.service;

import com.alura.gerenciador.servlet.service.interfaces.Acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Logout implements Acao {
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        return "redirect:entrada?acao=FormLogin";
    }
}

