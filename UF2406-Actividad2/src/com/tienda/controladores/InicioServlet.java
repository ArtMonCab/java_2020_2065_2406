package com.tienda.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tienda.accesodatos.Dao;
import com.tienda.accesodatos.ProductoDaoTreeMap;
import com.tienda.modelos.Producto;




@WebServlet(name = "inicio", urlPatterns = { "/inicio" })
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao<Producto> dao = ProductoDaoTreeMap.getInstancia();
		Iterable<Producto> productos = dao.obtenerTodos();
		request.setAttribute("productos", productos);
		request.getRequestDispatcher("/WEB-INF/vistas/inicio.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
