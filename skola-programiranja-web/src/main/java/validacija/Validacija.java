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
	
	
	
	
	
	

}
