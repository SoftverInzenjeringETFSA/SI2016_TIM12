package org.instasi.jeziki.springbootstarter.models;

import java.util.List;

public class TestWrapper {
	public TestWrapper(String naziv, String nazivKursa, String stepenKursa, List<Pitanje> pitanja) {
		super();
		this.naziv = naziv;
		this.nazivKursa = nazivKursa;
		this.stepenKursa = stepenKursa;
		this.pitanja = pitanja;
	}
	public TestWrapper()
	{}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getNazivKursa() {
		return nazivKursa;
	}
	public void setNazivKursa(String nazivKursa) {
		this.nazivKursa = nazivKursa;
	}
	public String getStepenKursa() {
		return stepenKursa;
	}
	public void setStepenKursa(String stepenKursa) {
		this.stepenKursa = stepenKursa;
	}
	public List<Pitanje> getPitanja() {
		return pitanja;
	}
	public void setPitanja(List<Pitanje> pitanja) {
		this.pitanja= pitanja;
	}
	private String naziv;
	private String nazivKursa;
	private String stepenKursa;
	private List<Pitanje> pitanja;
	
}
