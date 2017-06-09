package org.instasi.jeziki.springbootstarter.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PocetnaController {
	
	@RequestMapping("/pocetna")
	public String dajPocetnu()
	{
		return "Selam";
	}

}
