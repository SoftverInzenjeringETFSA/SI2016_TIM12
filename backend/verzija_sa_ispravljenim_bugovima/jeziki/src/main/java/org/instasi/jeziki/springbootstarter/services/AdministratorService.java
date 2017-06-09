package org.instasi.jeziki.springbootstarter.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.instasi.jeziki.springbootstarter.models.Administrator;
import org.instasi.jeziki.springbootstarter.models.Student;
import org.instasi.jeziki.springbootstarter.repositories.AdministratorRepository;
import org.instasi.jeziki.springbootstarter.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AdministratorService {

	
	private Date datum = new Date();
	@Autowired
	private AdministratorRepository administratorRepository;

	public void promijeniSifru(String korisnickoIme,String staraSifra,String novaSifra)
	{
		List<Administrator> lista = (List<Administrator>) administratorRepository.logInHelper(korisnickoIme, staraSifra);
		if(lista.size()==0)
			return;
		
		Administrator a = lista.get(0);
		a.setSifra(novaSifra);
		administratorRepository.save(a);
	}
	
	
	public void obrisiAdministratora(int id)
	{
		administratorRepository.delete(id);		
	}
	
	public List<Administrator> prikaziAdministratore()
	{
		List<Administrator> lista= new ArrayList<>();
		administratorRepository.findAll().forEach(lista::add);
		return lista;
	}
	
	public void dodajAdministratora(Administrator s)
	{
		administratorRepository.save(s);
	}
	
}
