package org.instasi.jeziki.springbootstarter.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.instasi.jeziki.springbootstarter.models.*;

import com.mysql.jdbc.Blob;;

@Entity

public class Lekcija {

	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Integer id;

	    //@Cascade({ CascadeType.SAVE_UPDATE })
	    @ManyToOne(targetEntity=Kurs.class)
	    @JoinColumn(name="kurs_id")
	    private Kurs kurs;
        @Column(name="naziv")
	    private String naziv;
        @Column(name="opis")
	    private String opis;

	    @Column(name="sadrzaj")
		@Lob
		private Blob sadrzaj;
	    


	    public Lekcija(Kurs kurs, String naziv, String opis) {
	        this.kurs = kurs;
	        this.naziv = naziv;
	        this.opis = opis;
	    }

	    public Blob getSadrzaj() {
			return sadrzaj;
		}

		public void setSadrzaj(Blob sadrzaj) {
			this.sadrzaj = sadrzaj;
		}

		public Lekcija() {
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer materijalId) {
	        this.id = materijalId;
	    }

	    public Kurs getKurs() {
	        return kurs;
	    }

	    public void setKurs(Kurs kurs) {
	        this.kurs = kurs;
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
