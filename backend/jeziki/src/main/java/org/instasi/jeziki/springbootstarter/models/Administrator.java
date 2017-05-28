package org.instasi.jeziki.springbootstarter.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrator {
	
	
	public Administrator()
	{
		
	}
	
	public Administrator(int id, String korisnickoIme, String sifra) {
		super();
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.sifra = sifra;
	}
	
	

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

	private int id;
	
    @Column(name = "korisnickoIme")

	private String korisnickoIme;
    @Column(name = "sifra")

	private String sifra;
	
	
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		if(korisnickoIme.isEmpty())
			throw new IllegalArgumentException("korisnicko Ime ne moze biti prazno");
		this.korisnickoIme = korisnickoIme;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		if(sifra.length() < 6)
			throw new IllegalArgumentException("sifra ne moze biti kraca od 6 karaktera");
		this.sifra = sifra;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString()
	{
		return "id = " + id + "username" + korisnickoIme;
	}
	
	
}
