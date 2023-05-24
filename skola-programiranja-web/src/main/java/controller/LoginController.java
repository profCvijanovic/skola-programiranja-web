package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Rola;
import model.User;
import servis.LoginService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(description = "login", urlPatterns = { "/LoginController" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginService service = new LoginService();
		//pokupimo iz requesta parametre - username i password
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("Logovanje je pokusao: " + userName);
		
		//Provera(validacija) da li su parametri null, prazni ili su popunjeni 
		boolean daLiSuParametriOk = service.proveriDaLiSuParametriOk(userName, password);
		
		System.out.println("Da li su parametri ok: " + daLiSuParametriOk);
		
		// ako parametri nisu ok - vrati se na stranicu za login.html
		if(!daLiSuParametriOk) {
			response.sendRedirect("stranice/login.html");
		}else {
			//parametri ok, trazimo usera
			User user = service.vratiUseraPoUserNameIpassword(userName, password);
			// ako je user = null, to znaci da user nepostoji u bazi - vrati me na logimn.html
			if( user == null ) {
				response.sendRedirect("stranice/login.html");
			}else {
				//ako postoji user 
				//Kreiram sesiju
				HttpSession session = request.getSession();
				//Ubacujem user-a u sesiju
				session.setAttribute("user", user);
				Rola rola = user.getRola();		
				//ako je rola null onda idi na login.html
				if(rola == null) {
					response.sendRedirect("stranice/login.html");
				}else {
					//ako je rola chief - idi na chief.jsp, 
					if(rola == Rola.CHIEF) {
						response.sendRedirect("view/chief.jsp");
					}
					//a ako je rola programer idi na programer.html
					if(rola == Rola.PROGRAMMER) {
						response.sendRedirect("stranice/programmer.html");
					}
				}		
			}
		}
		
		
	}

}
