package com.libreriaMF0227.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libreriaMF0227.accesodatos.Dao;
import com.libreriaMF0227.accesodatos.LibroDao;
import com.libreriaMF0227.modelos.Libro;


@WebServlet(name = "inicio", urlPatterns = { "/inicio" })
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao dao = LibroDao.getInstance();
		Iterable<Libro> libros = dao.getAll();
		request.setAttribute("libros", libros);
		request.getRequestDispatcher("/WEB-INF/vistas/inicio.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
