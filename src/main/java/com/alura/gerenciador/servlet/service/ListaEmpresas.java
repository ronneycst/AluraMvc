package com.alura.gerenciador.servlet.service;

import com.alura.gerenciador.servlet.model.Banco;
import com.alura.gerenciador.servlet.model.Empresa;
import com.alura.gerenciador.servlet.service.interfaces.Acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListaEmpresas implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
		request.setAttribute("empresas", lista);

		return "request:WEB-INF/view/listaEmpresas.jsp";
	}
}
