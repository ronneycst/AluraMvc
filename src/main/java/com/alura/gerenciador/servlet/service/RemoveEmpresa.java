package com.alura.gerenciador.servlet.service;

import com.alura.gerenciador.servlet.model.Banco;
import com.alura.gerenciador.servlet.service.interfaces.Acao;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveEmpresa implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println(id);
		
		Banco banco = new Banco();
		banco.removeEmpresa(id);

		return "redirect:entrada?acao=ListaEmpresas";
	}

}
