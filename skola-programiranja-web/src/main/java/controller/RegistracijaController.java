package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servis.RegistracijaService;

@WebServlet(description = "ovo je registracioni servlet", urlPatterns = { "/RegistracijaController" })
public class RegistracijaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Dobrodosli u doGET");
		
		RegistracijaService service = new RegistracijaService();
		
		//prihvati parametre sa forme	
		String userName = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		String repeatedPassword = request.getParameter("repeatedpassword").trim();
		
		boolean daLiJePassIstiKaoRepeatedPass = service.daLiJePassIstiKaoRepeatedPass(password, repeatedPassword);
		
		if(daLiJePassIstiKaoRepeatedPass) {
			System.out.println("Isti su pass i repeated pass");
			service.insertUser(userName, password);
			response.sendRedirect("stranice/uspesna_registracija.html");
		}else {
			System.out.println("Nisu isti pass i repeated pass");
			response.sendRedirect("stranice/registracija.html");
		}
		
	}


}
