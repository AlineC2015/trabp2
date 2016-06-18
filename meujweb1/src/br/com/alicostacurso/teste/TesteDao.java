package br.com.alicostacurso.teste;
import java.util.List;
import br.com.alicostacurso.entidades.Usuario;
import br.com.alicostacurso.jdbc.UsuarioDAO;

public class TesteDao {

	public static void main(String[] args) {		
		//testCadastrar();
		//testAlterar();
		//testExcluir();
		//testBuscarAll();
		//testAutenticar();
	}

	private static void testCadastrar() {
		Usuario usu = new Usuario();
		usu.setNome("Alex Gomes");
		usu.setLogin("alexg");
		usu.setSenha("ag123");
		UsuarioDAO uDao = new UsuarioDAO();
		uDao.cadastrar(usu);
	}
	
	private static void testAlterar() {
		Usuario usu = new Usuario();
		usu.setCod(2);
		usu.setNome("Patricia Silva");
		usu.setLogin("Patysil");
		usu.setSenha("ps123");
		
		UsuarioDAO uDao = new UsuarioDAO();
		uDao.alterar(usu);
	}
	
	private static void testExcluir() {
		Usuario usu = new Usuario();	
		usu.setCod(6);
			
		UsuarioDAO uDao = new UsuarioDAO();
		uDao.excluir(usu);
	}
	
	private static void testBuscarAll() {				
		UsuarioDAO uDao = new UsuarioDAO();
		List<Usuario> listaRes = uDao.buscarall();
		
		for(Usuario u: listaRes){
			System.out.println(u.getCod() +" "+ u.getNome() +" "+ u.getLogin() +" "+ u.getSenha());
		}
	}
		
	private static void testAutenticar() {				
		Usuario usu = new Usuario();
		usu.setLogin("roblima");
		usu.setSenha("rl23");
		
		UsuarioDAO uDao = new UsuarioDAO();
		uDao.autenticar(usu);
		
		}
	}
	
