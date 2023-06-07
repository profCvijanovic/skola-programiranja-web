package dto;

public class TimDto {
	
	private String nazivTima;
	private String opis;
	private int id;
	
	public TimDto() {
		
	}
	
	public TimDto(String nazivTima, String opis) {
		this.nazivTima = nazivTima;
		this.opis = opis;
	}

	public String getNazivTima() {
		return nazivTima;
	}
	public void setNazivTima(String nazivTima) {
		this.nazivTima = nazivTima;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
