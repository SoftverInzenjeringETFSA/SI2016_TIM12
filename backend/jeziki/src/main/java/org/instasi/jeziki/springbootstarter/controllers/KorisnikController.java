package org.instasi.jeziki.springbootstarter.controllers;

import javax.servlet.http.HttpSession;

import org.instasi.jeziki.springbootstarter.models.Administrator;
import org.instasi.jeziki.springbootstarter.services.KorisnikService;
import org.instasi.jeziki.springbootstarter.services.PredavacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class KorisnikController {
	@Autowired 
	 private HttpSession httpSession;
	@Autowired
	private KorisnikService korisnikService;
	
	

	
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
}
