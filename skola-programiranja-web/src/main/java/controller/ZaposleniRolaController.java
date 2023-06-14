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
import model.Adresa;
import model.UserDetails;
import servis.UserDetailsService;


/**
 * Servlet implementation class TimController
 */
@WebServlet("/ZaposleniRolaController")
public class ZaposleniRolaController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDetailsService service = new UserDetailsService();
		
		String idUser = request.getParameter("idUser");
		String plata = request.getParameter("plata");
		String sifraZaposlenog = request.getParameter("sifraZaposlenog");
		String idTim = request.getParameter("idTim");
		String[] pozicija = request.getParameterValues("pozicija");
		String idUserDetails = request.getParameter("idUserDetails");
		
		String rola = request.getParameter("rola");
	
		service.snimiRola(rola , idUser);
		service.snimiZaposlenog(plata , sifraZaposlenog, idTim, idUser, idUserDetails, pozicija);
		
		response.sendRedirect("InitUserDetailsController");
		
		
	}

}
