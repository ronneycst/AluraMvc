package com.alura.gerenciador.servlet.controller;

import com.alura.gerenciador.servlet.model.Banco;
import com.alura.gerenciador.servlet.model.Empresa;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/empresas")
public class EmpresasService extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
