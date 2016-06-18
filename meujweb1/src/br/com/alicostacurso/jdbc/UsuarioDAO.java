package br.com.alicostacurso.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alicostacurso.entidades.Usuario;

public class UsuarioDAO {

	private Connection conec = Conexao.getConnect();
	
	public void cadastrar(Usuario usuario) {
		//Monta sql
		String sql = "insert into usuarios (nome,login,senha) values (?,?,?)";
		
		//Constroe o PreparedStatement e põe o sql dentro
		try {
			PreparedStatement prep = conec.prepareStatement(sql);
			//substitui as interrogações pegando(get) os dados no aluno e setando(pondo) no prep
			prep.setString(1,usuario.getNome());
			prep.setString(2,usuario.getLogin());
			prep.setString(3,usuario.getSenha());
						
			prep.execute();
			prep.close();
			
			System.out.println("Usuário(a) cadastrado(a) com sucesso");
			
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar usuário");
			
			e.printStackTrace();
		}
	}

public void alterar(Usuario usuario) {	
	String sql = "update usuarios set nome=?,login=?,senha=? where cod=?";
	
	try {
		PreparedStatement prep = conec.prepareStatement(sql);
		
		prep.setString(1,usuario.getNome());
		prep.setString(2,usuario.getLogin());
		prep.setString(3,usuario.getSenha());
		prep.setInt(4,usuario.getCod());			
		
		prep.execute();
		prep.close();
		
		System.out.println("Registro Alterado");
		
	} catch (SQLException e) {
		System.out.println("Erro ao Alterar");
		
		e.printStackTrace();
	}
}

public void excluir(Usuario usuario) {	
	String sql = "delete from usuarios where cod = ?";
	
	try {
		PreparedStatement prep = conec.prepareStatement(sql);	
		prep.setInt(1,usuario.getCod());			
		
		prep.execute();
		prep.close();
		
		System.out.println("Registro Excluído");
		
	} catch (SQLException e) {
		System.out.println("Erro ao Excluir");
		
		e.printStackTrace();
	}
}

public List<Usuario> buscarall() {	
	String sql = "select * from usuarios";
	
	List<Usuario> lista = new ArrayList<Usuario>();
	try {
		PreparedStatement prep = conec.prepareStatement(sql);			
		ResultSet result = prep.executeQuery();
			
		while(result.next()) {			
			Usuario usu = new Usuario();
			usu.setCod(result.getInt("cod"));
			usu.setNome(result.getString("nome"));
			usu.setLogin(result.getString("login"));
			usu.setSenha(result.getString("senha"));
			
			lista.add(usu);
		}		
		prep.close();	
		System.out.println("Lista de Usuários Cadastrados");
		
	} catch (SQLException e) {
		System.out.println("Erro na busca");
		
		e.printStackTrace();
	}
	return lista;
	
}

	public Usuario buscaCod(Integer cod){
		String sql = "select * from usuarios where cod = ?";		
		Usuario usuario = null;
		try {
			PreparedStatement prep = conec.prepareStatement(sql);
			prep.setInt(1, cod);			
			ResultSet result = prep.executeQuery();
			
			if(result.next()){		
				usuario = new Usuario();
				usuario.setCod(result.getInt("cod"));
				usuario.setNome(result.getString("nome"));
				usuario.setLogin(result.getString("login"));
				usuario.setSenha(result.getString("senha"));
						
			}		
		} catch (SQLException e) {
			System.out.println("Registro não encontrado");
			e.printStackTrace();
		}
		return usuario; 
	}
	public Usuario autenticar(Usuario usuario){
		String sql = "select * from usuarios where login = ? and senha = ?";		
		try {
			PreparedStatement prep = conec.prepareStatement(sql);
			prep.setString(1, usuario.getLogin());
			prep.setString(2, usuario.getSenha());
					
			ResultSet result = prep.executeQuery();
			
			if(result.next()){		
				usuario = new Usuario();
				usuario.setCod(result.getInt("cod"));
				usuario.setNome(result.getString("nome"));
				usuario.setLogin(result.getString("login"));
				usuario.setSenha(result.getString("senha"));
				
			}		
			System.out.println("Olá " +result.getString("nome")+", Bem vindo(a) ao sistema de vendas ThecBike");
		} catch (SQLException e) {
			
			System.out.println("Usuário não encontrado");
			//e.printStackTrace();
		}
		return usuario; 
	}	
}