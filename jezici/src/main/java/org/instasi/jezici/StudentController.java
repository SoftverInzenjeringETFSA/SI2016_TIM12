package org.instasi.jezici;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.instasi.jezici.models.Student;
import org.instasi.jezici.service.StudentService;


@Controller 
@ComponentScan("org.instasi.jezici.service")
public class StudentController {
	
	private StudentService studentService;
	
	@Autowired(required = true)
	@Qualifier(value="studentService")
	public void setStudentService(StudentService ss){
		this.studentService = ss;
	}
	
	@RequestMapping(value = "/studenti", method = RequestMethod.GET)
	public String listaStudenata(Model model)
	{
		model.addAttribute("student", new Student());
		model.addAttribute("listaStudenata", this.studentService.listaStudenata());
		return "studenti";
	}
	
	@RequestMapping(value = "/registracija", method = RequestMethod.GET)
	public String registracijaStudentaUnos(Model model){
		return "registracija";
	}
	
	

	@RequestMapping(value = "/registracija", method = RequestMethod.POST)
	public String registracijaStudentaSpasavanje(Model model, @ModelAttribute("noviStudent") Student s, 
			BindingResult bindingResult){
		
		String poruka = "";
		if(bindingResult.hasErrors())
		{
		    List<FieldError> errors = bindingResult.getFieldErrors();
		    for (FieldError error : errors ) {
		        System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
		        poruka += error.getDefaultMessage() + "<br>";
		    }
		}
		else
		{
			poruka  = "Uspjesno ste se registrovali";
			try{
				studentService.dodajStudenta(s);
			}
			catch(Exception  ex)
			{
				poruka = ex.getMessage();
			}
			
			
		}
		model.addAttribute("poruka", poruka);
		return "rezultatRegistracije";
	}
	
	@RequestMapping(value = "/prijava", method = RequestMethod.GET)
	public String prijava(){
		return "prijava";
	}
	
	@RequestMapping(value = "/prijava", method = RequestMethod.POST)
	public String obradaPrijave(HttpServletRequest request,
			@RequestParam(value="korisnickoIme", required = true) String korisnickoIme,
			@RequestParam(value="sifra", required = true) String sifra
			){
		System.out.println(korisnickoIme + " " +sifra); 
		return "prijava";
	}


	
	@RequestMapping(value = "studenti/dodaj", method = RequestMethod.POST)
	public String dodajStudenta(@ModelAttribute("student") Student s){
		
		if(s.getId() == 0)
			this.studentService.dodajStudenta(s);
		else
			this.studentService.updateStudenta(s);
		
		return "redirect:/studenti";
	}
		
	

}
