package org.instasi.jeziki.springbootstarter.repositories;

import org.instasi.jeziki.springbootstarter.models.Administrator;
import org.instasi.jeziki.springbootstarter.models.Predavac;
import org.instasi.jeziki.springbootstarter.models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AdministratorRepository extends CrudRepository<Administrator,Integer> {

	@Query("select o from Administrator o "
			+ "where o.korisnickoIme= :korisnickoIme and o.sifra = :sifra"
			)
	Iterable<Administrator> logInHelper(@Param("korisnickoIme") String korisnickoIme,@Param("sifra") String sifra);
	
	@Query("select o from Administrator o "
			+ "where o.korisnickoIme= :korisnickoIme"
			)
	Iterable<Administrator> nadjiPoUsername(@Param("korisnickoIme") String korisnickoIme);
}
