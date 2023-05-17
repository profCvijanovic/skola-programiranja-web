package servis;

import validacija.Validacija;

public class RegistracijaService {
	
	Validacija validacija = new Validacija();

	public boolean daLiJePassIstiKaoRepeatedPass(String password, String repeatedPassword) {
		return validacija.daLiJePassIstiKaoRepeatedPass(password, repeatedPassword);
	}

}
