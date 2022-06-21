package com.alura.gerenciador.servlet.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();

	private static List<Usuario> listaUsuarios = new ArrayList<>();

	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		lista.add(empresa);
		lista.add(empresa2);

		Usuario usu1 = new Usuario();
		usu1.setLogin("Ronney");
		usu1.setSenha("123456");

		Usuario usu2 = new Usuario();
		usu2.setLogin("Thayane");
		usu2.setSenha("123456");
		listaUsuarios.add(usu1);
		listaUsuarios.add(usu2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Empresa buscaEmpresaPelaId(Integer id) {
		for (Empresa empresa : lista) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}
	public List<Usuario> getListaUsuarios(){
		return Banco.listaUsuarios;
	}

	public Usuario existeUsuario(String login, String senha) {
		for(Usuario usuario : Banco.listaUsuarios){
			if(usuario.ehIgual(login,senha))
				return usuario;
		}
		return  null;
	}
}
