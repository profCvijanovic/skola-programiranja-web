package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servis.DeleteTimService;


/**
 * Servlet implementation class AddTimController
 */
@WebServlet("/DeleteTimController")
public class DeleteTimController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DeleteTimService service = new DeleteTimService();
		
		String id = request.getParameter("idTim");
		
		service.deleteTim(id);
		
		response.sendRedirect("TimController");
		
	}
	

}
