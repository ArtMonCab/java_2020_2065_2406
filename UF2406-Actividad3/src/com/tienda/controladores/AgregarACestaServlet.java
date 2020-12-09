package com.tienda.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tienda.accesodatos.Dao;
import com.tienda.accesodatos.ProductoDaoTreeMap;
import com.tienda.modelos.Producto;



@WebServlet(name = "agregaracesta", urlPatterns = { "/agregaracesta" })
public class AgregarACestaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao<Producto> dao = ProductoDaoTreeMap.getInstancia();

		LinkedHashMap<Long, Producto> cesta = new LinkedHashMap<>();

		Enumeration<String> ids = request.getParameterNames();

		String sId;
		Long id;
		Integer cantidad;

		Producto producto;
		
		BigDecimal totalcompra = new BigDecimal(0);

		while (ids.hasMoreElements()) {
			sId = ids.nextElement();
			id = Long.parseLong(sId);
			cantidad = Integer.parseInt(request.getParameter(sId));

			if (cantidad > 0) {

				producto = dao.obtenerPorId(id);
				producto.setCantidad(cantidad);

				cesta.put(id, producto);
				totalcompra = totalcompra.add(producto.getPrecio().multiply(new BigDecimal(cantidad)));
			}
		}

		request.getSession().setAttribute("cesta", cesta);
		request.getSession().setAttribute("totalcompra", totalcompra);

		response.sendRedirect(request.getContextPath() + "/cesta");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
