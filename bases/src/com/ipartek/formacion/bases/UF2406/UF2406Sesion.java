package com.ipartek.formacion.bases.UF2406;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "sesion-uf2406", urlPatterns = { "/sesion-uf2406" })
public class UF2406Sesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    {
	        response.setContentType("text/plain");
		    HttpSession session = request.getSession(true);
	        

	        // Imprimir información


	        //Hora del último acceso
	        Date ultimoAcceso = new Date(session.getLastAccessedTime());
	        response.getWriter().println("Último acceso: " + ultimoAcceso);
	        
	        response.getWriter().println("---------");
	        
	        //Navegador
	        String navegador = request.getHeader("user-agent");
	        response.getWriter().println("Navegador: " + navegador);
	       

	        response.getWriter().println("---------");
	        
	        
	        //Usuario
	        String dataName = "Nombre del usuario";
	        if (dataName != null && dataName.length() > 0) {
	            String dataValue = request.getParameter("nombre");
	            session.setAttribute(dataName, dataValue);
	        }

	        //Imprime el nombre del usuario

	        Enumeration e = session.getAttributeNames();
	        
	        while (e.hasMoreElements()) {
	            String name = (String)e.nextElement();
	            String value = session.getAttribute(name).toString();
	            response.getWriter().println(name + " : " + value);
	            	          
	        }
	    }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
