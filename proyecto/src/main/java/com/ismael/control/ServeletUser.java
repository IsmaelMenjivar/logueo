package com.ismael.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ismael.DAO.UsuarioDAO;
import com.ismael.model.TbUsuariop;

/**
 * Servlet implementation class ServeletUser
 */
public class ServeletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String usu = request.getParameter("usuario");
		String contra = request.getParameter("contra");
		
		
		TbUsuariop usuario = new TbUsuariop();
		
		UsuarioDAO usuDAO = new UsuarioDAO(); 
		
		usuario.setUsuario(usu);
		usuario.setContrasenia(contra);
		
		int verificarusuario = usuDAO.ingresoUsuario(usuario).size(); 
		
		if (verificarusuario==1) {
			System.out.println("OK ENTRASTE");
		}else {
			System.out.println("ERROR");
		}
		response.sendRedirect("index.jsp");
	}

}
