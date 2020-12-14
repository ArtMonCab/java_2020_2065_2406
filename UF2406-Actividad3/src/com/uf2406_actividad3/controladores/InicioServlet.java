package com.uf2406_actividad3.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uf2406_actividad3.accesodatos.LibroDao;


@WebServlet(name = "inicio", urlPatterns = { "/inicio" })
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("libros", LibroDao.getInstancia().obtenerTodos());
		request.getRequestDispatcher("/WEB-INF/vistas/inicio.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
