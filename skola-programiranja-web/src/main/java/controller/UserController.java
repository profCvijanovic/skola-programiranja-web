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
import dto.UserDto;
import servis.TimService;
import servis.UserService;

/**
 * Servlet implementation class TimController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserService service = new UserService();
		
		List<UserDto> listaUsera = service.vratiSveUsere();
		
		request.setAttribute("listaUsera", listaUsera);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/users.jsp");
		
		dispatcher.forward(request, response);
		
		
	}

}
