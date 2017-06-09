package org.instasi.jeziki.springbootstarter.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;


@Entity

public class Predavanje {
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    //@OneToOne(fetch = FetchType.EAGER)
   // @JoinColumn(name = "nivo_kursa_id")
    //@Cascade({ CascadeType.SAVE_UPDATE })
	
	 //@JoinColumn(name="kurs_id")
		//@ManyToOne(targetEntity=Kurs.class)


	   // private Kurs kurs;
    
	@Column(name = "nazivKursa")

	private String nazivKursa;
	
	public String getStepenKursa() {
		return stepenKursa;
	}

	public void setStepenKursa(String stepenPredavanja) {
		this.stepenKursa = stepenPredavanja;
	}

	public String getOpisPredavanja() {
		return opisPredavanja;
	}

	public void setOpisPredavanja(String opisPredavanja) {
		this.opisPredavanja = opisPredavanja;
	}

	@Column(name = "stepenKursa")

	private String stepenKursa;
		
	
    @Column(name = "opisPredavanja")

    private String opisPredavanja;

  

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer predavanjeId) {
        this.id = predavanjeId;
    }

   

    public String getNazivKursa() {
        return nazivKursa;
    }

    public void setNazivKursa(String nazivPredavanja) {
        this.nazivKursa= nazivPredavanja;
    }
    
   

   
}
