package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
	
	public Connection getConnection() throws InstantiationException, 
											 IllegalAccessException, 
											 ClassNotFoundException, 
											 SQLException{
	
	Connection conexao;
	
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	
	String strConexao = "jdbc:mysql://localhost:3306/escola";
	String strUsuario = "root";
	String strSenha = "";
	
	conexao = DriverManager.getConnection(strConexao,strUsuario,strSenha);
	
	return conexao;
	
	}
	
}
