package org.instasi.jeziki.springbootstarter.controllers;

import javax.servlet.http.HttpSession;

import org.instasi.jeziki.springbootstarter.models.Administrator;
import org.instasi.jeziki.springbootstarter.models.PromjenaSifre;
import org.instasi.jeziki.springbootstarter.services.AdministratorService;
import org.instasi.jeziki.springbootstarter.services.KorisnikService;
import org.instasi.jeziki.springbootstarter.services.PredavacService;
import org.instasi.jeziki.springbootstarter.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class KorisnikController {
	@Autowired 
	 private HttpSession httpSession;
	@Autowired
	private KorisnikService korisnikService;
	@Autowired
	private AdministratorService administratorService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private PredavacService predavacService;
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/promijeniSifru")
	public void promjenaSifre(@RequestBody PromjenaSifre s)
	{
		if(korisnikService.provjeriUsername(s.getKorisnickoIme()) )
		{
			if(s.getTip().equals("administrator"))
			{
				administratorService.promijeniSifru(s.getKorisnickoIme(),s.getStaraSifra(),s.getNovaSifra());
			}
			else if(s.getTip().equals("student"))
			{
				studentService.promijeniSifru(s.getKorisnickoIme(),s.getStaraSifra(),s.getNovaSifra());

			}
			else
			{
				predavacService.promijeniSifru(s.getKorisnickoIme(),s.getStaraSifra(),s.getNovaSifra());

			}
		}
		
		
	}

	
	@RequestMapping(method=RequestMethod.POST, value="/logIn")
	public String LogIn(@RequestBody LogInfo s)
	{
		
		korisnikService.setSession(httpSession);
		if(korisnikService.logIn(s))
			return httpSession.getAttribute("tip").toString();
		else
			return "greska";
	}
	
	@RequestMapping(value = "/odjava", method = RequestMethod.GET)
	public String odjava(){
		korisnikService.logOut();
		return "redirect:/pocetna";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/slobodanUsername")
	public String daLiJeSlobodanUserName(@RequestParam(value="korisnickoIme", required=true) String korisnickoIme)
	{
		if(korisnikService.provjeriUsername(korisnickoIme))
			return "zauzeto";
		return "slobodno";
	}
}
