package org.instasi.jeziki.springbootstarter.services;

import org.instasi.jeziki.springbootstarter.models.Zahtjev;
import org.instasi.jeziki.springbootstarter.repositories.TestRepository;
import org.instasi.jeziki.springbootstarter.repositories.ZahtjevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZahtjevService {
	@Autowired
	private ZahtjevRepository zahtjevRepository;
	
	public void kreirajZahtjev(Zahtjev z)
	{
		zahtjevRepository.save(z);
	}
}
