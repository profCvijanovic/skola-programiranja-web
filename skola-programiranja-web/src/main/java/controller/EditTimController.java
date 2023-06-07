package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servis.EditTimService;

/**
 * Servlet implementation class AddTimController
 */
@WebServlet("/EditTimController")
public class EditTimController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EditTimService service = new EditTimService();
		
		String id = request.getParameter("idTim");
		String noviNazivTima = request.getParameter("nazivTima");
		String noviOpis = request.getParameter("opis");
		
		service.editTim(id, noviNazivTima, noviOpis);
		
		response.sendRedirect("TimController");
		
	}
	

}
