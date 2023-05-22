package validacija;

public class Validacija {

	public boolean daLiJePassIstiKaoRepeatedPass(String password, String repeatedPassword) {
		
		if(password != null && !password.equals("") && repeatedPassword != null && !repeatedPassword.equals("")) {
			if(password.equals(repeatedPassword)) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}	
	}

	public boolean proveriDaLiSuParametriOk(String userName, String password) {
		
		if( userName == null || password == null) {
			return false;	
		}else {
			
			if(userName.trim().equals("") || password.trim().equals("")) {
				return false;
			}else {
				return true;
			}		
		}	
		
	}
	
	
	
	
	
	
	
	

}
