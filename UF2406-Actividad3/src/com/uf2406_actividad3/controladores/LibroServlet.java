package com.uf2406_actividad3.controladores;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uf2406_actividad3.accesodatos.Dao;
import com.uf2406_actividad3.accesodatos.LibroDao;
import com.uf2406_actividad3.modelo.Libro;


@WebServlet(name = "libro", urlPatterns = { "/libro" })
public class LibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger LOGGER = Logger.getLogger(LibroServlet.class.getName());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recoger información de la petición

		String id = request.getParameter("id");

		// 2. Poner información dentro de un modelo
		// 3. Tomar decisiones según lo recibido

		if (id != null) {
			Dao<Libro> dao = LibroDao.getInstancia();

			Libro libro = dao.obtenerPorId(Long.parseLong(id));

			// 4. Generar modelo para la vista

			request.setAttribute("libro", libro);
		}

		// 5. Redirigir a otra vista
		request.getRequestDispatcher("/WEB-INF/vistas/libro.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
