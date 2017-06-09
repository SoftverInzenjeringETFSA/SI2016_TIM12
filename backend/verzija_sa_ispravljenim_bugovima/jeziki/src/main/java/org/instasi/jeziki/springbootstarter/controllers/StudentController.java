package org.instasi.jeziki.springbootstarter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Date;

import org.instasi.jeziki.springbootstarter.models.*;
import org.instasi.jeziki.springbootstarter.services.KorisnikService;
import org.instasi.jeziki.springbootstarter.services.StudentService;
import org.instasi.jeziki.springbootstarter.services.ZahtjevService;
@RestController

public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired 
	 private HttpSession httpSession;
	@Autowired 
	 private ZahtjevService zahtjevService;
	@Autowired 
	 private KorisnikService korisnikService;
	
	@RequestMapping("/studenti")
	public List<Student> prikaziStudente()
	{
		return studentService.prikaziStudente();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/studenti")
	public void dodajStudenta(@RequestBody Student s)
	{		
		if(!korisnikService.provjeriUsername(s.getKorisnickoIme()))

		studentService.dodajStudenta(s);
	}
	
	
	
	
	@RequestMapping(value = "/zahtjevZaNivoKursa", method = RequestMethod.POST)
	public @ResponseBody
	void uploadFileHandler(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {

		if(httpSession.getAttribute("tip").equals("student"))
		
		
		
		
		if (!file.isEmpty() ) 
				 {
			try {
				byte[] bytes = file.getBytes();

			
				
				
				
				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				rootPath = "C:\\";
				
				File dir = new File(rootPath + File.separator + httpSession.getAttribute("username").toString());
				if (!dir.exists())
					dir.mkdirs();
				
				Zahtjev z = new Zahtjev();
				z.setLokacijaSlike(dir.getAbsolutePath());
				z.setStudent(studentService.dajStudentaPoUsername(httpSession.getAttribute("username").toString()));
				
				zahtjevService.kreirajZahtjev(z);

				
				dir = new File(dir + File.separator + name);
				if (!dir.exists())
					dir.mkdirs();
				
				
				System.out.println(dir.getAbsolutePath());

				
				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() 
						+ File.separator + name + ".jpg");
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
