package org.instasi.jeziki.springbootstarter.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Zahtjev {

	public Zahtjev() {
	}

	public Zahtjev(Student student, String lokacijaSlike) {
		super();
		this.student = student;
		this.lokacijaSlike = lokacijaSlike;
	}
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="student_id")
    private Student student;
	
	@Column(name = "lokacijaSlike")

	private String lokacijaSlike;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getLokacijaSlike() {
		return lokacijaSlike;
	}

	public void setLokacijaSlike(String lokacijaSlike) {
		this.lokacijaSlike = lokacijaSlike;
	}
	
	
}
