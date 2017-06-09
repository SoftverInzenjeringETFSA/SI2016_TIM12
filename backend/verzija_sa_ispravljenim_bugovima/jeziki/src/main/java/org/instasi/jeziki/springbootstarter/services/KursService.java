package org.instasi.jeziki.springbootstarter.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.instasi.jeziki.springbootstarter.models.Administrator;
import org.instasi.jeziki.springbootstarter.models.Kurs;
import org.instasi.jeziki.springbootstarter.repositories.AdministratorRepository;
import org.instasi.jeziki.springbootstarter.repositories.KursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class KursService {
	@Autowired
	private KursRepository kursRepository;

	
	
	public List<Kurs> prikaziKurseve()
	{
		List<Kurs> lista= new ArrayList<>();
		kursRepository.findAll().forEach(lista::add);
		return lista;
	}
	
	public void dodajKurs(Kurs s)
	{
		kursRepository.save(s);
	}
	
	public Kurs dajKursPoNazivuiStepenu(String naziv,String stepen)
	{
		List<Kurs> kursevi= (List<Kurs>) kursRepository.dajKursPoNazivuiStepenu(naziv,stepen);
		return kursevi.get(0);
	}
}
