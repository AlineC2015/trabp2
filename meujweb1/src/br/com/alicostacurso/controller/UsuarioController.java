package br.com.alicostacurso.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alicostacurso.entidades.Usuario;
import br.com.alicostacurso.jdbc.UsuarioDAO;

@WebServlet("/usucontrol.do")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsuarioController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("chamando método GET");
		
		//obter a lista
		UsuarioDAO uDao = new UsuarioDAO();
		List<Usuario> lista = uDao.buscarall();
					
		//atribuir no request a lista
		request.setAttribute("msg", "listaabaixo");
		request.setAttribute("lista", lista);
		
		//encaminhamento ao JSP
		RequestDispatcher saida = request.getRequestDispatcher("listausu.jsp");
		saida.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("chamando métodp POST");
		
	}

}
