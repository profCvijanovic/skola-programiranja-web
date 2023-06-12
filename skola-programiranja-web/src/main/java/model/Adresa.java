package model;

import javax.persistence.Embeddable;

@Embeddable
public class Adresa {
	
	private String drzava;
	private String grad;
	private String ulica;
	private String postanskiBroj;
	
	public Adresa() {
		
	}
	
	public Adresa(String drzava, String grad, String ulica, String postanskiBroj) {
		this.drzava = drzava;
		this.grad = grad;
		this.ulica = ulica;
		this.postanskiBroj = postanskiBroj;
	}
	public String getDrzava() {
		return drzava;
	}
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	public String getGrad() {
		return grad;
	}
	public void setGrad(String grad) {
		this.grad = grad;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public String getPostanskiBroj() {
		return postanskiBroj;
	}
	public void setPostanskiBroj(String postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}
	
	

}
