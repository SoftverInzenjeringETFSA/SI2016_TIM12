package org.instasi.jeziki.springbootstarter.models;

public class PrihvatanjeWrapper {

	private int student;
	private String nazivKursa;
	private String stepenKursa;
	public PrihvatanjeWrapper() {
	}
	public PrihvatanjeWrapper(int student, String nazivKursa, String stepenKursa) {
		super();
		this.student = student;
		this.nazivKursa = nazivKursa;
		this.stepenKursa = stepenKursa;
	}
	public int getStudent() {
		return student;
	}
	public void setStudent(int student) {
		this.student = student;
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
	
}
