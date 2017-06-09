package org.instasi.jeziki.springbootstarter.repositories;

import org.instasi.jeziki.springbootstarter.models.Predavac;
import org.instasi.jeziki.springbootstarter.models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends CrudRepository<Student,Integer> {


	@Query("select o from Student o "
			+ "where o.korisnickoime= :korisnickoIme and o.sifra = :sifra"
			)
	Iterable<Student> logInHelper(@Param("korisnickoIme") String korisnickoIme,@Param("sifra") String sifra);
	
	@Query("select o from Student o "
			+ "where o.ime = :ime and o.prezime = :prezime "
			)
	Iterable<Student> nadjiStudentaPoImenuPrezimenu(@Param("ime") String ime,@Param("prezime") String prezime);
	
	
	@Query("select o from Student o where o.korisnickoime = :korisnickoIme"
			)
	Iterable<Student> nadjiStudentaPoUsername(@Param("korisnickoIme") String korisnickoIme);
}
