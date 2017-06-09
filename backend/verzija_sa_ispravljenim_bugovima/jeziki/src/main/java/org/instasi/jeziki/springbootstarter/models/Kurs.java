package org.instasi.jeziki.springbootstarter.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Kurs {


	public Kurs(int id, String naziv, String stepen) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.stepen = stepen;
	}
	
	public Kurs()
	{
		
	}

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String naziv;
	
	private String stepen;
	
	
	
	
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getStepen() {
		return stepen;
	}
	public void setStepen(String stepen) {
		this.stepen = stepen;
	}
	
	
	
	
	
	
	public String getNaziv()
	{
		return naziv;
	}
	
	public void setNaziv(String naziv)
	{
		if(naziv.isEmpty())
			throw new IllegalArgumentException("naziv ne moze biti prazan");
		this.naziv = naziv;
	}

	@Override
	public String toString()
	{
		return "id = " + id + " naziv: " + naziv;
	}
	
	
}
