package br.com.alicostacurso.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection getConnect(){
		Connection conec = null;
		
		try {
			conec = DriverManager.getConnection("jdbc:postgresql://localhost:5432/loja","postgres","123456");
			System.out.println("Conectado com sucesso");
			
		} catch (SQLException e) {
			System.out.println("Erro na conexão" + e.getMessage());
			
			//e.printStackTrace();
		}
			return conec;
	}
		
	
}
