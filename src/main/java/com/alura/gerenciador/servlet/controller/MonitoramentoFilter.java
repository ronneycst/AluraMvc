package com.alura.gerenciador.servlet.controller;

import com.alura.gerenciador.servlet.service.interfaces.Acao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/entrada")
public class MonitoramentoFilter extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String param = req.getParameter("acao");
        String nomeClasse = "com.alura.gerenciador.servlet.service." + param;
        String nome = null;

        try {
            Class classe = Class.forName(nomeClasse);
            Acao acao = (Acao) classe.newInstance();
            nome = acao.executa(req,resp);
        } catch (ClassNotFoundException |InstantiationException | IllegalAccessException e) {
            throw new ServletException(e);
        }

        String [] reqOrDisp = nome.split(":");
        if(reqOrDisp[0].equals("request")){
            RequestDispatcher rd = req.getRequestDispatcher(reqOrDisp[1]);
            rd.forward(req, resp);
        }else{
            resp.sendRedirect(reqOrDisp[1]);
        }

    }
}
