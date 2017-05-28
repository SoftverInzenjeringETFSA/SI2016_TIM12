package org.instasi.jeziki.springbootstarter.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import org.instasi.jeziki.springbootstarter.models.Student;
import org.instasi.jeziki.springbootstarter.models.Kurs;


@Entity
public class Zapis {

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDatumPolaganja() {
		return datumPolaganja;
	}

	public void setDatumPolaganja(Date datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}

	public Double getOstvareniRezultat() {
		return ostvareniRezultat;
	}

	public void setOstvareniRezultat(Double ostvareniRezultat) {
		this.ostvareniRezultat = ostvareniRezultat;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "datumPolaganja")

    private Date datumPolaganja;
    @Column(name = "ostvareniRezultat")

    private Double ostvareniRezultat;

    @ManyToOne(targetEntity=Student.class)
    @JoinColumn(name="studentId")
    private Student student;
    
    @ManyToOne(targetEntity=Kurs.class)
    @JoinColumn(name="kursId")
    private Kurs kurs;

	public Kurs getKurs() {
		return kurs;
	}

	public void setKurs(Kurs kurs) {
		this.kurs = kurs;
	}

	
}
