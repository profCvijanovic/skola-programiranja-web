package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.TimDto;
import servis.TimService;

/**
 * Servlet implementation class TimController
 */
@WebServlet("/TimController")
public class TimController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TimService service = new TimService();
		
		List<TimDto> listaTimova = service.vratiSveTimove();
		
		request.setAttribute("listaTimova", listaTimova);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/tim.jsp");
		
		dispatcher.forward(request, response);
		
		
	}

}
