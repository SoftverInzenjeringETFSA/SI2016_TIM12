package org.instasi.jeziki.springbootstarter.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.instasi.jeziki.springbootstarter.models.Kurs;
import org.instasi.jeziki.springbootstarter.models.Pitanje;
import org.instasi.jeziki.springbootstarter.models.Predavanje;
import org.instasi.jeziki.springbootstarter.models.Student;
import org.instasi.jeziki.springbootstarter.models.TestWrapper;
import org.instasi.jeziki.springbootstarter.models.Zapis;
import org.instasi.jeziki.springbootstarter.models.ZapisWrapper;
import org.instasi.jeziki.springbootstarter.repositories.ZapisRepository;
import org.instasi.jeziki.springbootstarter.services.KorisnikService;
import org.instasi.jeziki.springbootstarter.services.KursService;
import org.instasi.jeziki.springbootstarter.services.PredavacService;
import org.instasi.jeziki.springbootstarter.services.PredavanjeService;
import org.instasi.jeziki.springbootstarter.services.StudentService;
import org.instasi.jeziki.springbootstarter.services.TestService;
import org.instasi.jeziki.springbootstarter.services.ZapisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import aj.org.objectweb.asm.TypeReference;

@RestController

public class PredavacController {
	@Autowired 
	 private HttpSession httpSession;
	@Autowired
	private KursService kursService;
	@Autowired
	private PredavanjeService predavanjeService;
	@Autowired
	private PredavacService predavacService;
	@Autowired
	private TestService testService;
	@Autowired
	private ZapisService zapisService;
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping(method=RequestMethod.POST, value="/objaviTermin")
	public void objaviTermin(@RequestBody Predavanje p)
	{
		//Kurs k =p.getNivoKursa();
		
		//System.out.println(p.getNazivPredavanja());
		//Kurs trazeni=kursService.dajKursPoNazivuiStepenu(k.getNaziv(),k.getStepen());
		
		//p.setNivoKursa(trazeni);
		predavanjeService.dodajPredavanje(p);
		
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/unesiRezultat")
	public void unesiRezultatTesta(
			
			@RequestBody ZapisWrapper zapisWrapper)
	{
		String nazivKursa = zapisWrapper.getNazivKursa();
		String stepenKursa = zapisWrapper.getStepenKursa();
		
		List<String> imenaStudenata = zapisWrapper.getImenaStudenata();
		List<String> prezimenaStudenata = zapisWrapper.getPrezimenaStudenata();
		List<Double> bodoviStudenata = zapisWrapper.getBodovi();
		
		
		List<Zapis> zapisi = zapisService.prikaziZapise();
		
		int i=0;
		for(i=0;i<imenaStudenata.size();i++)
		{
			List<Student> pomoc = (List<Student>) studentService.dajStudentaPoImenuPrezimenu(imenaStudenata.get(i), prezimenaStudenata.get(i));
			Student s = pomoc.get(0);
			Zapis z = zapisService.dajZapisPoStudentu(s.getId(), nazivKursa, stepenKursa);
			
			
			z.setOstvareniRezultat(bodoviStudenata.get(i));
			
			zapisService.kreirajZapis(z);
			
			
		}
		
		
		
		
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/kreirajTest")
	public void kreirajTest(
			
			@RequestBody TestWrapper testWrapper)

			//@RequestBody List<Pitanje> pitanja, @RequestBody String nazivTesta, @RequestBody String nazivKursa,
			//@RequestBody String stepenKursa)
	{		//System.out.println(myObjectId);

		String naziv = testWrapper.getNaziv();
		System.out.println(naziv);
		String nazivKursa = testWrapper.getNazivKursa();
		String stepenKursa = testWrapper.getStepenKursa();
		List<Pitanje> pitanja = testWrapper.getPitanja();
		
		testService.kreirajTest(pitanja, naziv, nazivKursa, stepenKursa);
		
		//ObjectMapper mapper = new ObjectMapper();
		//JsonNode node;
		//try {
		//	node = mapper.readTree(jsonulaz);
		//	String naziv= mapper.convertValue(node.get("naziv"), String.class);
		//	String nazivKursa= mapper.convertValue(node.get("nazivKursa"), String.class);
		//	String stepenKursa=mapper.convertValue(node.get("stepenKursa"), String.class);
		//	ArrayList<Pitanje> pitanja =mapper.convertValue(node.get("pitanja"),ArrayList<Pitanje>);
	//		List<Pitanje> myObjects = mapper.readValue(jsonulaz, mapper.getTypeFactory().constructCollectionType(List.class, Pitanje.class));
	//		System.out.println(naziv);
	//	} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
	//	}
		
		
		
		//Kurs k =p.getNivoKursa();
		
		//System.out.println(p.getNazivPredavanja());
		//Kurs trazeni=kursService.dajKursPoNazivuiStepenu(k.getNaziv(),k.getStepen());
		
		//p.setNivoKursa(trazeni);
		//testService.kreirajTest(pitanja,nazivTesta,nazivKursa,stepenKursa);
		
		
	}
	
	@RequestMapping(value = "/postavljanjeMaterijala", method = RequestMethod.POST)
	public @ResponseBody
	void uploadFileHandler(@RequestParam("kurs") int kurs,
			@RequestParam("file") MultipartFile file) {

		
		
		
		
		if (!file.isEmpty() ) 
				 {
			try {
				byte[] bytes = file.getBytes();

			
				
				
				
				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				rootPath = "C:\\";
				
				File dir = new File(rootPath + File.separator + Integer.toString(kurs));
				if (!dir.exists())
					dir.mkdirs();
				
				

				
				dir = new File(dir + File.separator + Integer.toString(kurs));
				if (!dir.exists())
					dir.mkdirs();
				
				
				System.out.println(dir.getAbsolutePath());

				
				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() 
						+ File.separator + Integer.toString(kurs) + ".pdf");
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				
				
				
				System.out.println("uspjesan upload");
				

			} catch (Exception e) {
				System.out.println(e.getMessage());

			}
		} else {
			System.out.println("prazan fajl");


		}
		

		}
	
	
	
	
}
