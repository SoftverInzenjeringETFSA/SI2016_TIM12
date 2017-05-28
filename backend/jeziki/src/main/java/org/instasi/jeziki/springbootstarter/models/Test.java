package org.instasi.jeziki.springbootstarter.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity

public class Test {

	public Test() {
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public Kurs getKurs() {
		return kurs;
	}


	public void setKurs(Kurs kurs) {
		this.kurs = kurs;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String naziv;
	
	
	@ManyToOne(targetEntity=Kurs.class)
    @JoinColumn(name="kurs_id")
    private Kurs kurs;
}
