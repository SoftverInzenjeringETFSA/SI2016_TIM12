package org.instasi.jeziki.springbootstarter.models;

import java.util.List;

public class ZapisWrapper {
	public ZapisWrapper() {
	}
	public ZapisWrapper(List<String> imenaStudenata, List<String> prezimenaStudenata, List<Double> bodovi) {
		super();
		this.imenaStudenata = imenaStudenata;
		this.prezimenaStudenata = prezimenaStudenata;
		this.bodovi = bodovi;
	}
	public List<String> getImenaStudenata() {
		return imenaStudenata;
	}
	public void setImenaStudenata(List<String> imenaStudenata) {
		this.imenaStudenata = imenaStudenata;
	}
	public List<String> getPrezimenaStudenata() {
		return prezimenaStudenata;
	}
	public void setPrezimenaStudenata(List<String> prezimenaStudenata) {
		this.prezimenaStudenata = prezimenaStudenata;
	}
	public List<Double> getBodovi() {
		return bodovi;
	}
	public void setBodovi(List<Double> bodovi) {
		this.bodovi = bodovi;
	}
	private List<String>imenaStudenata;
	private List<String>prezimenaStudenata;
	private List<Double> bodovi;
	private String nazivKursa;
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
	private String stepenKursa;
	
}
