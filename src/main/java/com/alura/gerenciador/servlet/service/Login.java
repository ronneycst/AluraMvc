package com.alura.gerenciador.servlet.service;

import com.alura.gerenciador.servlet.model.*;
import com.alura.gerenciador.servlet.service.interfaces.Acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Banco banco = new Banco();
        Usuario usuarioLogin = banco.existeUsuario(login,senha);

        if(usuarioLogin != null){
            System.out.println("Encontrado");
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuarioLogado",usuarioLogin);
            return "redirect:entrada?acao=ListaEmpresas";
        }
        return "redirect:entrada?acao=FormLogin";
    }
}
