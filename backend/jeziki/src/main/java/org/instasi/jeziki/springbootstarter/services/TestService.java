package org.instasi.jeziki.springbootstarter.services;

import java.util.List;

import org.instasi.jeziki.springbootstarter.models.Kurs;
import org.instasi.jeziki.springbootstarter.models.Pitanje;
import org.instasi.jeziki.springbootstarter.models.Test;
import org.instasi.jeziki.springbootstarter.repositories.KursRepository;
import org.instasi.jeziki.springbootstarter.repositories.PitanjeRepository;
import org.instasi.jeziki.springbootstarter.repositories.StudentRepository;
import org.instasi.jeziki.springbootstarter.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class TestService {
	@Autowired
	private TestRepository testRepository;
	@Autowired
	private PitanjeRepository pitanjeRepository;
	@Autowired
	private KursRepository kursRepository;
	
	public void kreirajTest(List<Pitanje> pitanja,String naziv,String nazivKursa,String stepenKursa)
	{
		
		
		
		Test t = new Test();
		t.setNaziv(naziv);
		List<Kurs> kursevi =(List<Kurs>)kursRepository.dajKursPoNazivuiStepenu(nazivKursa, stepenKursa);
		t.setKurs(kursevi.get(0));
		
		for(Pitanje p : pitanja)
		{
			p.setTest(t);
			pitanjeRepository.save(p);
		}
		
	}
	

}
