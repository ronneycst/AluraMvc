package com.alura.gerenciador.servlet.service.interfaces;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface  Acao {
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
