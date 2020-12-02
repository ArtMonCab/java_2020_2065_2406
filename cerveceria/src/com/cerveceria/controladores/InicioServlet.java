package com.cerveceria.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cerveceria.accesodatos.Dao;
import com.cerveceria.accesodatos.CervezaDaoFreeMap;
import com.cerveceria.modelos.Cerveza;


@WebServlet(name = "inicio", urlPatterns = { "/inicio" })
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao<Cerveza> dao = CervezaDaoFreeMap.getInstancia();
		Iterable<Cerveza> productos = dao.buscarTodas();
		request.setAttribute("cervezas", productos);
		request.getRequestDispatcher("/WEB-INF/vistas/inicio.jsp").forward(request,  response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
