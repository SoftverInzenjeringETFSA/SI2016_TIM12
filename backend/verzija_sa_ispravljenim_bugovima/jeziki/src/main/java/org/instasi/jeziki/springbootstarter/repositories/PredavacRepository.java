package org.instasi.jeziki.springbootstarter.repositories;

import org.instasi.jeziki.springbootstarter.models.Predavac;
import org.instasi.jeziki.springbootstarter.models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface PredavacRepository extends CrudRepository<Predavac,Integer> {

	
	@Query("select o from Predavac o "
			+ "where o.korisnickoIme= :korisnickoIme and o.sifra = :sifra"
			)
	Iterable<Predavac> logInHelper(@Param("korisnickoIme") String korisnickoIme,@Param("sifra") String sifra);
	
	@Query("select o from Predavac o "
			+ "where o.ime = :ime and o.prezime = :prezime "
			)
	Iterable<Predavac> nadjiPredavacaPoImenuPrezimenu(@Param("ime") String ime,@Param("prezime") String prezime);


	@Query("select o from Predavac o "
			+ "where o.korisnickoIme= :korisnickoIme"
			)
	Iterable<Predavac> nadjiPoUsername(@Param("korisnickoIme") String korisnickoIme);

}
