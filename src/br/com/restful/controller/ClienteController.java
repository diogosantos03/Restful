package br.com.restful.controller;

import java.util.List;

import br.com.restful.dao.ClienteDAO;
import br.com.restful.model.Cliente;

public class ClienteController {
	public List<Cliente> listarTodos(){
		return ClienteDAO.getInstancia().listarTodos();
	}
	
}
