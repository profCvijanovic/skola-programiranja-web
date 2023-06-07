package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servis.AddTimService;

/**
 * Servlet implementation class AddTimController
 */
@WebServlet("/AddTimController")
public class AddTimController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AddTimService service = new AddTimService();
		
		String nazivTima = request.getParameter("nazivTima");
		String opis = request.getParameter("opis");
		
		service.dodajTim(nazivTima, opis);
		
		response.sendRedirect("TimController");
		
	}
	

}
