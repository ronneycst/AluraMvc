package com.alura.gerenciador.servlet.service;

import com.alura.gerenciador.servlet.model.Banco;
import com.alura.gerenciador.servlet.model.Empresa;
import com.alura.gerenciador.servlet.service.interfaces.Acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostraEmpresa implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		
		Empresa empresa = banco.buscaEmpresaPelaId(id);
		
		System.out.println(empresa.getNome());

		request.setAttribute("empresa", empresa);

		return "request:WEB-INF/view/formAlteraEmpresa.jsp";
	}

}
