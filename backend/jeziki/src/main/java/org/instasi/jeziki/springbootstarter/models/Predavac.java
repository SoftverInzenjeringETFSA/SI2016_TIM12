package org.instasi.jeziki.springbootstarter.models;

import java.util.regex.Pattern;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity

public class Predavac {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
    @JoinColumn(name="kurs_id")
	@OneToOne()

    private Kurs kurs;
    
	
    @Column(name = "ime")

	private String ime;
    @Column(name = "korisnickoIme")

	private String korisnickoIme;
    @Column(name = "prezime")

	private String prezime;
	
    @Column(name = "email")

	private String email;
	
    @Column(name = "brojTelefona")

	private String brojTelefona;
	
    @Column(name = "sifra")

	private String sifra;
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		if(ime.isEmpty())
			throw new IllegalArgumentException("Ime ne moze biti prazno");
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		if(prezime.isEmpty())
			throw new IllegalArgumentException("prezime ne moze biti prazno");
		this.prezime = prezime;
	}
	
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String prezime) {
		if(prezime.isEmpty())
			throw new IllegalArgumentException("username  ne moze biti prazno");
		this.korisnickoIme= prezime;
	}
	
	
	
	public String getBrojTelefona() {
		return brojTelefona;
	}
	public void setBrojTelefona(String broj) {
		this.brojTelefona= broj;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		if(!pattern.matcher(email).matches())
			throw new IllegalArgumentException("email nije ispravan");
		this.email = email;
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
	
	public Kurs getKurs() {
		return kurs;
	}
	public void setKurs(Kurs id) {
		this.kurs = id;
	}
	
	

	@Override
	public String toString()
	{
		return "id = " + id + " ime: " + ime + " prezime: "  + prezime;
	}
	
	
	
	
}
