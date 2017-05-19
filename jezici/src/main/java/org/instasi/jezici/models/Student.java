package org.instasi.jezici.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;
import java.util.regex.Pattern;

@Entity
@Table(name = "Student")
public class Student {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String ime;
	
	@Column(nullable = false)
	private String prezime;
	
	@Column(nullable = false)
	private String jmbg;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date datumRodjenja;
	
	@Column(nullable = false)
	private String mjestoRodjenja;
	
	@Column(nullable = false, unique = true)
	private String adresaBoravista;
	
	@Column(nullable = false)
	private String korisnickoIme;
	
	@Column(nullable = false)
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
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		if(jmbg.length() != 13)
			throw new IllegalArgumentException("jmbg mora imati 13 znakova");
		this.jmbg = jmbg;
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
	public Date getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(Date datumRodjenja) {
		Date d = new Date();
		if(datumRodjenja.after(d))
			throw new IllegalArgumentException("datum Rodjenja neispravan");
		this.datumRodjenja = datumRodjenja;
	}
	public String getMjestoRodjenja() {
		return mjestoRodjenja;
	}
	public void setMjestoRodjenja(String mjestoRodjenja) {
		if(mjestoRodjenja.isEmpty())
			throw new IllegalArgumentException("mjesto Rodjenja ne moze biti prazno");
		this.mjestoRodjenja = mjestoRodjenja;
	}
	public String getAdresaBoravista() {
		return adresaBoravista;
	}
	public void setAdresaBoravista(String adresaBoravista) {
		if(adresaBoravista.isEmpty())
			throw new IllegalArgumentException("adresa Boravista ne moze biti prazno");
		this.adresaBoravista = adresaBoravista;
	}
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
		return "id = " + id + " ime: " + ime + " prezime: "  + prezime;
	}
	
	

}
