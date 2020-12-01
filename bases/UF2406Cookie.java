package com.ipartek.formacion.bases.UF2406;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "cookie-uf2406", urlPatterns = { "/cookie-uf2406" })
public class UF2406Cookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = null;
		String color = null;
		
		Cookie[] cookies = request.getCookies();
		
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals("nombre")) {
				nombre = cookie.getValue();
				break;
			}
		}
		
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals("color")) {
				color = cookie.getValue();
				break;
			}
		}
		
		response.setContentType("text/plain");
		response.getWriter().println(nombre);
		response.getWriter().println(color);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre =request.getParameter("nombre");
		String color =request.getParameter("color");
		
		Cookie cookieNombre = new Cookie("nombre", nombre);
		Cookie cookieColor = new Cookie("color",color);
		
		
		response.addCookie(cookieNombre);	
		response.addCookie(cookieColor);	
		
		response.sendRedirect("cookie-uf2406");
	}

}
