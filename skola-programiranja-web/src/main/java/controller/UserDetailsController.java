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
@WebServlet("/UserDetailsController")
public class UserDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDetailsService service = new UserDetailsService();
		
		
		String drzava = request.getParameter("drzava");
		String grad = request.getParameter("grad");
		String ulica = request.getParameter("ulica");
		String postanskiBroj = request.getParameter("postanskiBroj");
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		
		String idUser = request.getParameter("idUser");
		String plata = request.getParameter("plata");
		String sifraZaposlenog = request.getParameter("sifraZaposlenog");
		String idTim = request.getParameter("idTim");
		String[] pozicija = request.getParameterValues("pozicija");
		
		
		String rola = request.getParameter("rola");
		
		Adresa adresa = new Adresa(drzava, grad, ulica, postanskiBroj);
		UserDetails userDetails = new UserDetails(ime, prezime, adresa);
		
		service.snimiUserDetails(userDetails);
		
		response.sendRedirect("InitUserDetailsController");
		
		
	}

}
