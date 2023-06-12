package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ime;
	private String prezime;
	@Embedded
	private Adresa adresa;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<Contact> kontakti = new ArrayList<Contact>();
	
	public UserDetails() {
		
	}
	
	public UserDetails(String ime, String prezime, Adresa adresa) {
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public Adresa getAdresa() {
		return adresa;
	}
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
	public List<Contact> getKontakti() {
		return kontakti;
	}
	public void setKontakti(List<Contact> kontakti) {
		this.kontakti = kontakti;
	}
	
	
	

}
