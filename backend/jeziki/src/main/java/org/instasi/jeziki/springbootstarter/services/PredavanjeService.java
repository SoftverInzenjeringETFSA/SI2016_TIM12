package org.instasi.jeziki.springbootstarter.services;

import org.instasi.jeziki.springbootstarter.models.Kurs;
import org.instasi.jeziki.springbootstarter.models.Predavanje;
import org.instasi.jeziki.springbootstarter.repositories.KursRepository;
import org.instasi.jeziki.springbootstarter.repositories.PredavanjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PredavanjeService {
	@Autowired
	private PredavanjeRepository predavanjeRepository;

	
	public void dodajPredavanje(Predavanje s)
	{
		predavanjeRepository.save(s);
	}
}
