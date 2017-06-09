package org.instasi.jeziki.springbootstarter.services;

import org.instasi.jeziki.springbootstarter.models.Lekcija;
import org.instasi.jeziki.springbootstarter.repositories.LekcijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LekcijaService {
	
	@Autowired LekcijaRepository lekcijaRepository;
	
	public void dodajLekciju(Lekcija l)
	{
		lekcijaRepository.save(l);
	}

}
