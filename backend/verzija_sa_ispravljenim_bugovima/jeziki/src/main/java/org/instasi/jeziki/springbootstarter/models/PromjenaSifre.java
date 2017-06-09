package org.instasi.jeziki.springbootstarter.models;

public class PromjenaSifre {

	private String tip;
	private String korisnickoIme;
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getStaraSifra() {
		return staraSifra;
	}
	public void setStaraSifra(String staraSifra) {
		this.staraSifra = staraSifra;
	}
	public String getNovaSifra() {
		return novaSifra;
	}
	public void setNovaSifra(String novaSifra) {
		this.novaSifra = novaSifra;
	}
	private String staraSifra;
	private String novaSifra;
	
}
