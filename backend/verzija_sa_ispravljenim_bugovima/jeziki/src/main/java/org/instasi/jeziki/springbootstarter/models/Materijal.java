package org.instasi.jeziki.springbootstarter.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.instasi.jeziki.springbootstarter.models.*;;

@Entity

public class Materijal {

	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Integer id;

	    //@Cascade({ CascadeType.SAVE_UPDATE })
	    @ManyToOne(targetEntity=Predavanje.class)
	    @JoinColumn(name="predavanje_id")
	    private Predavanje predavanje;

	    private String naziv;

	    private String opis;

	    // ponovo blob materijal


	    public Materijal(Predavanje predavanje, String naziv, String opis) {
	        this.predavanje = predavanje;
	        this.naziv = naziv;
	        this.opis = opis;
	    }

	    public Materijal() {
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer materijalId) {
	        this.id = materijalId;
	    }

	    public Predavanje getPredavanje() {
	        return predavanje;
	    }

	    public void setPredavanje(Predavanje predavanje) {
	        this.predavanje = predavanje;
	    }

	    public String getNaziv() {
	        return naziv;
	    }

	    public void setNaziv(String naziv) {
	        this.naziv = naziv;
	    }

	    public String getOpis() {
	        return opis;
	    }

	    public void setOpis(String opis) {
	        this.opis = opis;
	    }
}
