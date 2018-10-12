package br.com.restful.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.restful.controller.ClienteController;
import br.com.restful.model.Cliente;

@Path("/cliente")
public class ClienteResource {
	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Cliente> listarTodos(){
		 return new ClienteController().listarTodos();
	}

}
