package cadastros;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	
	Connection connection;
	PreparedStatement statement;
	ResultSet resultSet;
	CallableStatement call;
	
	/**
	 * Método responsável por abrir uma conexão com o banco de dados
	 * @throws Exception
	 * 
	 * @author Wyltamar Oliviera 
	 */
	public void conectar()throws Exception {
		
		String url = "jdbc:postgresql://localhost:5432/cadastros";
		String user = "postgres";
		String password = "admin";
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url,user,password);
			System.out.println("Conexão com o banco estabelecida com sucesso!");
		} catch (SQLException | ClassNotFoundException ex) {

			System.out.println("Erro ao conectar com o banco de dados");
		}
	}
	
	/**
	 * Método que fecha a conexão com o banco de dados.
	 * @throws SQLException
	 * @author Wyltamar Douglas
	 */
	public void closeConnection() throws SQLException {
		
		connection.close();
	}
	
	

}
