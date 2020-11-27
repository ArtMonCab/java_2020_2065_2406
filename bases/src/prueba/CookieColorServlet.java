package prueba;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "cookie-color", urlPatterns = { "/cookie-color" })
public class CookieColorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = null;
		String color = null;
		int i = 0;
		
		Cookie[] cookies = request.getCookies();
		
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals("nombre")) {
				nombre = cookie.getValue();
				break;
				
			}

		}
		
		response.setContentType("text/plain");
		response.getWriter().println(nombre);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
		String nombre =request.getParameter("nombre");
		String color =request.getParameter("color");
		
		
		Cookie cookie = new Cookie("nombre",nombre);
		response.addCookie(cookie);
		Cookie cookie2 = new Cookie("color",color);
		response.addCookie(cookie2);
		
			
		
		response.sendRedirect("cookie-color");
	}

}
