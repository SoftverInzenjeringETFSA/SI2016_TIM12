package org.instasi.jeziki.springbootstarter.models;

import java.util.Date;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	
	public Student()
	{
		
	}
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private int id;
    @Column(name = "ime")

	private String ime;
    @Column(name = "prezime")

	private String prezime;
    @Column(name = "jmbg")

	private String jmbg;
    @Column(name = "email")

	private String email;
    @Column(name = "datumRodjenja")

	private String datumrodjenja;
    @Column(name = "mjestoRodjenja")

	private String mjestorodjenja;
    @Column(name = "adresaBoravista")

	private String adresaboravista;
    @Column(name = "korisnickoIme")

	private String korisnickoime;
    @Column(name = "sifra")

	private String sifra;
	
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
	public String getDatumRodjenja() {
		return datumrodjenja;
	}
	public void setDatumRodjenja(String datumRodjenja) {
	
		this.datumrodjenja = datumRodjenja;
	}
	public String getMjestoRodjenja() {
		return mjestorodjenja;
	}
	public void setMjestoRodjenja(String mjestoRodjenja) {
		if(mjestoRodjenja.isEmpty())
			throw new IllegalArgumentException("mjesto Rodjenja ne moze biti prazno");
		this.mjestorodjenja = mjestoRodjenja;
	}
	public String getAdresaBoravista() {
		return adresaboravista;
	}
	public void setAdresaBoravista(String adresaBoravista) {
		if(adresaBoravista.isEmpty())
			throw new IllegalArgumentException("adresa Boravista ne moze biti prazno");
		this.adresaboravista = adresaBoravista;
	}
	public String getKorisnickoIme() {
		return korisnickoime;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		if(korisnickoIme.isEmpty())
			throw new IllegalArgumentException("korisnicko Ime ne moze biti prazno");
		this.korisnickoime = korisnickoIme;
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
