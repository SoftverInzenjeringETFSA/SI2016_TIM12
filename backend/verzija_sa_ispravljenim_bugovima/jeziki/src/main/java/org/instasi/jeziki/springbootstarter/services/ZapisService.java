package org.instasi.jeziki.springbootstarter.services;

import java.util.ArrayList;
import java.util.List;

import org.instasi.jeziki.springbootstarter.models.Kurs;
import org.instasi.jeziki.springbootstarter.models.Student;
import org.instasi.jeziki.springbootstarter.models.Zapis;
import org.instasi.jeziki.springbootstarter.repositories.KursRepository;
import org.instasi.jeziki.springbootstarter.repositories.ZahtjevRepository;
import org.instasi.jeziki.springbootstarter.repositories.ZapisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ZapisService {
	@Autowired
	private ZapisRepository zapisRepository;
	@Autowired
	private KursRepository kursRepository;
	
	
	public void kreirajZapis(Zapis z)
	{
		zapisRepository.save(z);
	}
	
	public List<Zapis> prikaziZapise()
	{
		List<Zapis> lista= new ArrayList<>();
		zapisRepository.findAll().forEach(lista::add);
		return lista;
	}
	
	public Zapis dajZapisPoStudentu(int id,String nazivKursa,String stepenKursa)
	{
		List<Zapis> zapisi = (List<Zapis>) zapisRepository.findAll();
		List<Zapis> trazeni = null;
		for(Zapis z : zapisi)
		{
			if (z.getStudent().getId()==id  )
				{
				List<Kurs> kursevi = (List<Kurs>) kursRepository.dajKursPoNazivuiStepenu(nazivKursa, stepenKursa);
				Kurs k = kursevi.get(0);
				System.out.println(k.getId());
				System.out.println(z.getKurs().getId());
				
				if(k.getId()==z.getKurs().getId())
				return z;
				}
		}
		return null;
	}
}
