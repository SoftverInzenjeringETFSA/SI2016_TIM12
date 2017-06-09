package org.instasi.jeziki.springbootstarter.controllers;

public class LogInfo {

	public LogInfo(String korisnickoIme, String sifra) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.sifra = sifra;
	}
	
	public LogInfo()
	{
		
	}
	private String korisnickoIme;
	private String sifra;
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
}
