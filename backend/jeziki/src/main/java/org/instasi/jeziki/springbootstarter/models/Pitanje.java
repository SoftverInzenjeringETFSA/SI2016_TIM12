package org.instasi.jeziki.springbootstarter.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity

public class Pitanje {
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPitanje() {
		return pitanje;
	}

	public void setPitanje(String pitanje) {
		this.pitanje = pitanje;
	}

	public String getOdgovor() {
		return odgovor;
	}

	public void setOdgovor(String odgovor) {
		this.odgovor = odgovor;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
	private String pitanje;
	private String odgovor;
	
	@ManyToOne(	cascade = {CascadeType.ALL})
    @JoinColumn(name="test_id")
    private Test test;
}
