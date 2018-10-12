package br.com.restful.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static final String USUARIO = "system";
	public static final String SENHA = "346460";
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public Connection criarConexao() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DRIVER, USUARIO, SENHA);
			/*PreparedStatement stm = conn.prepareStatement("INSERT INTO CLIENTE(codigo, nome, cidade, uf) VALUES (?,?,?,?)");
			stm.setInt(1, 0);
			stm.setString(2, "");
			stm.setString(3, "");
			stm.setString(4, "");
			
			stm.executeUpdate();
			stm.close();*/
		} catch (SQLException e) {
			System.out.println("Erro ao conectar o banco");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public void fecharConexao(Connection conn, PreparedStatement stm, ResultSet resultSet) {
		
		try {
			if(conn != null) {
				conn.close();
			}
			if(stm != null) {
				stm.close();
			}
			if(resultSet != null) {
				resultSet.close();
			}
		}catch(SQLException e) {
			System.out.println("Erro ao fechar conexao!");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
}
