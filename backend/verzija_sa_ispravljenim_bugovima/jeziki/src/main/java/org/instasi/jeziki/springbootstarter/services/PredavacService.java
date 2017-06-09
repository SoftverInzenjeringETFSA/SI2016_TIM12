package org.instasi.jeziki.springbootstarter.services;

import java.util.ArrayList;
import java.util.List;

import org.instasi.jeziki.springbootstarter.models.Administrator;
import org.instasi.jeziki.springbootstarter.models.Kurs;
import org.instasi.jeziki.springbootstarter.models.Predavac;
import org.instasi.jeziki.springbootstarter.models.Student;
import org.instasi.jeziki.springbootstarter.repositories.AdministratorRepository;
import org.instasi.jeziki.springbootstarter.repositories.PredavacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PredavacService {
	@Autowired
	private PredavacRepository predavacRepository;
	
	
	public void promijeniSifru(String korisnickoIme,String staraSifra,String novaSifra)
	{
		List<Predavac> lista = (List<Predavac>) predavacRepository.logInHelper(korisnickoIme, staraSifra);
		if(lista.size()==0)
			return;
		
		Predavac a = lista.get(0);
		a.setSifra(novaSifra);
		predavacRepository.save(a);
	}
	
	
	
	
	public List<Predavac> prikaziPredavace()
	{
		List<Predavac> lista= new ArrayList<>();
		predavacRepository.findAll().forEach(lista::add);
		return lista;
	}
	
	public void dodajPredavaca(Predavac s)
	{
		predavacRepository.save(s);
	}
	public void dodajPredavaca(Predavac s,Kurs k)
	{
		s.setKurs(k);
		predavacRepository.save(s);
	}

	public Iterable<Predavac> dajPredavacaPoImenuPrezimenu(String ime,String prezime)
	{
		return predavacRepository.nadjiPredavacaPoImenuPrezimenu(ime, prezime);
	}
	
	
	
	public void obrisiPredavaca(int id)
	{
		predavacRepository.delete(id);		
	}
	
	public void obrisiPredavaca(Predavac id)
	{
		predavacRepository.delete(id);		
	}
	
	public void updatePredavaca(int id, Predavac s)
	{
		predavacRepository.save(s);
	}

}
