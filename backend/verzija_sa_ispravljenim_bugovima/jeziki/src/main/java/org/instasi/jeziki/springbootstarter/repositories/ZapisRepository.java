package org.instasi.jeziki.springbootstarter.repositories;

import org.instasi.jeziki.springbootstarter.models.Student;
import org.instasi.jeziki.springbootstarter.models.Zapis;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ZapisRepository extends CrudRepository<Zapis,Integer> {

	
}
