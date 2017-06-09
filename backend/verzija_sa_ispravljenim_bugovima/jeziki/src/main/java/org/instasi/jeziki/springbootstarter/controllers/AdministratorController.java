package org.instasi.jeziki.springbootstarter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Arrays;
import java.util.Date;

import org.instasi.jeziki.springbootstarter.models.*;
import org.instasi.jeziki.springbootstarter.services.AdministratorService;
import org.instasi.jeziki.springbootstarter.services.KorisnikService;
import org.instasi.jeziki.springbootstarter.services.KursService;
import org.instasi.jeziki.springbootstarter.services.PredavacService;
import org.instasi.jeziki.springbootstarter.services.StudentService;
import org.instasi.jeziki.springbootstarter.services.ZapisService;

@RestController
public class AdministratorController {

	@Autowired
	private AdministratorService administratorService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private PredavacService predavacService;
	@Autowired
	private KursService kursService;
	@Autowired
	private ZapisService zapisService;
	@Autowired
	private KorisnikService korisnikService;
	
	
	@RequestMapping("/administratori")
	public List<Administrator> prikaziAdministratore()
	{
		return administratorService.prikaziAdministratore();
	}
	
	@RequestMapping("/predavaci")
	public List<Predavac> prikaziPredavace()
	{
		return predavacService.prikaziPredavace();
	}
	
	@RequestMapping("/kursevi")
	public List<Kurs> prikaziKurseve()
	{
		return kursService.prikaziKurseve();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/obrisiAdministratora")
	public void obrisiAdministratora(@RequestParam(value="id", required=true) int id)
	{
		List<Administrator> lista = administratorService.prikaziAdministratore();
		for(Administrator a : lista)
		{
			if(a.getId() == id)
				administratorService.obrisiAdministratora(a.getId());

		}
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/administratori")
	public void dodajAdministratora(@RequestBody Administrator s)
	{
		if(!korisnikService.provjeriUsername(s.getKorisnickoIme()))
		administratorService.dodajAdministratora(s);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/dodajPredavaca")
	public void dodajPredavaca(@RequestBody Predavac s)
	{
		if(!korisnikService.provjeriUsername(s.getKorisnickoIme()))

		predavacService.dodajPredavaca(s);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/otkljucavanjeKursa")
	public List<Student> prihvatiStudentaZaKurs()
	{
		
		return studentService.prikaziStudente();
		
	}
	@RequestMapping(method=RequestMethod.POST, value="/otkljucavanjeKursa")
	public void prihvatiStudentaZaKurs(
			
			@RequestBody PrihvatanjeWrapper prihvatanjeWrapper)
	{
		
		Zapis z = new Zapis();
		z.setStudent(studentService.dajStudenta((prihvatanjeWrapper.getStudent())));
		z.setKurs(kursService.dajKursPoNazivuiStepenu(prihvatanjeWrapper.getNazivKursa(),prihvatanjeWrapper.getStepenKursa()));
		zapisService.kreirajZapis(z);
		
	}
	
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/dodajKurs")
	public void dodajKurs(@RequestBody Kurs s)
	{
		
		kursService.dodajKurs(s);
		
	}
	
	@RequestMapping("/prikaziPredavacaImePrezime")
	public Iterable<Predavac> ObrisiPredavaca()
	{
		 return predavacService.dajPredavacaPoImenuPrezimenu("adam", "adam");
	}
	
	@RequestMapping("/prikaziStudentaImePrezime")
	public Iterable<Student> PrikaziStudenta()
	{
		 return studentService.dajStudentaPoImenuPrezimenu("adam", "adam");
	}
	
	@RequestMapping("/obrisiPredavaca/{id}")
	public void ObrisiPredavaca(@PathVariable int id)
	{
		 predavacService.obrisiPredavaca(id);
	}
	
	
	
	
	
	@RequestMapping("/obrisiStudenta/{id}")
	public void ObrisiStudenta(@PathVariable int id)
	{
		 studentService.obrisiStudenta(id);
	}
	
	

}
