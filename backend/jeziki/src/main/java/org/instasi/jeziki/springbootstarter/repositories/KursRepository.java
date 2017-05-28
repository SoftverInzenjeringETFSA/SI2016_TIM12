package org.instasi.jeziki.springbootstarter.repositories;

import org.instasi.jeziki.springbootstarter.models.Kurs;
import org.instasi.jeziki.springbootstarter.models.Predavac;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface KursRepository extends CrudRepository<Kurs,Integer> {
	@Query("select o from Kurs o "
			+ "where o.naziv = :naziv and o.stepen = :stepen"
			)
	Iterable<Kurs> dajKursPoNazivuiStepenu(@Param("naziv") String naziv,@Param("stepen") String stepen);


}
