package com.ipartek.formacion.bases.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookie-color/*")
public class CookieColor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idioma = null;
		
		Cookie[] cookies = request.getCookies();
		
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals("color")) {
				idioma = cookie.getValue();
				break;
			}
		}
		
		response.setContentType("text/plain");
		response.getWriter().println(idioma);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idioma = request.getParameter("color");
		
		Cookie cookie = new Cookie("color", idioma);
		
		response.addCookie(cookie);
		
		response.sendRedirect("cookie-color");
	}

}
