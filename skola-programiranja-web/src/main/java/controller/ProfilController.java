package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ProfilDto;
import servis.ProfilService;

/**
 * Servlet implementation class ProfilController
 */
@WebServlet(description = "ovde je profilusera", urlPatterns = { "/ProfilController" })
public class ProfilController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProfilService service = new ProfilService();
		
		String idUser = request.getParameter("idUser");
		
		System.out.println("User id: " + idUser);
		
		ProfilDto profil = service.vratiProfilnePodatke(idUser);
		
		System.out.println("Username: " + profil.getUserName());
		System.out.println("Sifra: " + profil.getSifraZaposlenog());
		System.out.println("Ime: " + profil.getIme());
		System.out.println("Prezime: " + profil.getPrezime());
		System.out.println("Drzava: " + profil.getDrzava());
		System.out.println("Grad: " + profil.getGrad());
		System.out.println("Ulica: " + profil.getUlica());
		System.out.println("Postanski broj: " + profil.getPostanskiBroj());
		System.out.println("Tim: " + profil.getNazivTima());
		
		
		
	}

}
