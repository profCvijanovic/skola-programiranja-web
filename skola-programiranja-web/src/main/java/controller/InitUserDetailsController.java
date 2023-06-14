package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.PozicijaDto;
import dto.TimDto;
import dto.UserDetailsDto;
import servis.InitUserDetailsService;


/**
 * Servlet implementation class TimController
 */
@WebServlet("/InitUserDetailsController")
public class InitUserDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		InitUserDetailsService service = new InitUserDetailsService();
		
		String idUser = request.getParameter("idUser");
		
		List<TimDto> listaTimova = service.vratiSveTimove();
		List<PozicijaDto> listaPozicija = service.vratiSvePozicije();
		List<UserDetailsDto> listaUserDetails = service.vratiSveUserDetails();
		
		request.setAttribute("listaTimova", listaTimova);
		request.setAttribute("listaPozicija", listaPozicija);
		request.setAttribute("listaUserDetails", listaUserDetails);
		request.setAttribute("idUser", idUser);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/init_user_detail.jsp");
		
		dispatcher.forward(request, response);
		
		
	}

}
