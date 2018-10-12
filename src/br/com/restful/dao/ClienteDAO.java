package br.com.restful.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.restful.factory.ConnectionFactory;
import br.com.restful.model.Cliente;

public class ClienteDAO extends ConnectionFactory{
	
	private static ClienteDAO instancia;
	
	public static ClienteDAO getInstancia() {
		if(instancia == null) {
			instancia = new ClienteDAO();
		}
		return instancia;
	}

	public List<Cliente> listarTodos(){
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet resultSet = null;
		List<Cliente> clientes = new ArrayList<Cliente>();
		conn = criarConexao();
		
		try {
			stm = conn.prepareStatement("SELECT * FROM CLIENTE");
			resultSet = stm.executeQuery();
			while(resultSet.next()) {
				System.out.println("Dentro while");
				Cliente cliente = new Cliente();
				cliente.setCod(resultSet.getInt(0));
				cliente.setNome(resultSet.getString(1));
				cliente .setCidade(resultSet.getString(2));
				cliente.setUf(resultSet.getString(3));
				clientes.add(cliente);
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			fecharConexao(conn, stm, resultSet);
		}
		System.out.println("**************************");
		for(Cliente c : clientes) {
			System.out.println("Nomes dos Cliente "+c.getNome());
		}
		return clientes;
	}
}
