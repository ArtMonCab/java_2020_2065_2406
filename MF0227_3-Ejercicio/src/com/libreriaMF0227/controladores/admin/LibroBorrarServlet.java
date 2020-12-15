package com.libreriaMF0227.controladores.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libreriaMF0227.accesodatos.Dao;
import com.libreriaMF0227.accesodatos.LibroDao;
import com.libreriaMF0227.modelos.Libro;




@WebServlet(name = "/admin/borrar", urlPatterns = { "//admin/borrar" })
public class LibroBorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Dao<Libro> dao = LibroDao.getInstance();
		
		dao.delete(Integer.parseInt(id));
		
		request.setAttribute("alertaTexto", "Borrado efectuado correctamente");
		request.setAttribute("alertaNivel", "success");
		
		request.getRequestDispatcher("/admin/index").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
