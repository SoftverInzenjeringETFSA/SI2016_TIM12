package org.instasi.jeziki.springbootstarter.services;

import javax.servlet.http.HttpSession;


import org.instasi.jeziki.springbootstarter.repositories.AdministratorRepository;
import org.instasi.jeziki.springbootstarter.repositories.PredavacRepository;
import org.instasi.jeziki.springbootstarter.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.instasi.jeziki.springbootstarter.controllers.LogInfo;
import org.instasi.jeziki.springbootstarter.models.*;


import java.util.List;
@Service
public class KorisnikService{

	
	@Autowired
	private AdministratorRepository administratorRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private PredavacRepository predavacRepository;
	private HttpSession ses ;

	
	

	public boolean provjeriUsername(String korisnickoIme)
	{
		List<Predavac> listaPredavaca = (List<Predavac>) predavacRepository.nadjiPoUsername(korisnickoIme );
		List<Student> listaStudenata= (List<Student>) studentRepository.nadjiStudentaPoUsername(korisnickoIme );
		List<Administrator> listaAdministratora= (List<Administrator>) administratorRepository.nadjiPoUsername(korisnickoIme);
		if(listaPredavaca.size() != 0|| listaStudenata.size()!=0|| listaAdministratora.size()!=0)
		{
			return true;
		}
		else
			return false;
	}
	
	
	public boolean logIn(LogInfo s)
	{
		
		
		
		
		String korisnickoIme=s.getKorisnickoIme();
		String sifra=s.getSifra();
				
		List<Predavac> listaPredavaca = (List<Predavac>) predavacRepository.logInHelper(korisnickoIme, sifra);
		List<Student> listaStudenata= (List<Student>) studentRepository.logInHelper(korisnickoIme, sifra);
		List<Administrator> listaAdministratora= (List<Administrator>) administratorRepository.logInHelper(korisnickoIme, sifra);

		
		if(listaPredavaca.size() != 0|| listaStudenata.size()!=0|| listaAdministratora.size()!=0)
		{
			getSession().setAttribute("username", korisnickoIme);
			
			
			
			if(listaPredavaca.size()!=0)
				getSession().setAttribute("tip", "predavac");
			else if(listaStudenata.size()!=0)
				getSession().setAttribute("tip", "student");
			else
				getSession().setAttribute("tip", "administrator");
			
			return true;

		}
		
		return false;
		

		
	/*	
		
		if(getPredavacDao().listaPredavaca()!= null)
				{
		listaPredavaca = getPredavacDao().listaPredavaca();
				
		
		
		
		for(Predavac p : listaPredavaca)
		{
			if(p.getKorisnickoIme().equals(username) && p.getSifra().equals(sifra))
			{
				if(getSession()!=null)
					System.out.println("Dobrodosao predavac");
				
				getSession().setAttribute(username, username);
				getSession().setAttribute("tip", "predavac");
				return true;
			}
				
		}
				}
		
		if(getStudentDao().listaStudenata()!= null)
		{

		listaStudenata = getStudentDao().listaStudenata();
		
		
		
		for(Student p : listaStudenata)
		{
			if(p.getKorisnickoIme().equals(username) && p.getSifra().equals(sifra))
			{
				
				if(getSession()!=null)
					System.out.println("Dobrodosao student");

				
				getSession().setAttribute(username, username);
				getSession().setAttribute("tip", "student");
				return true;
			}
				
		}
		}
		
		if(getAdministratorDao().listaAdministratora()!= null)
		{

		listaAdministratora = getAdministratorDao().listaAdministratora();
		
		
		for(Administrator p : listaAdministratora)
		{
			if(p.getKorisnickoIme().equals(username) && p.getSifra().equals(sifra))
			{
				if(getSession()!=null)
					System.out.println("Dobrodosao admin");
				
				getSession().setAttribute(username, username);
				getSession().setAttribute("tip", "administrator");
				return true;
			}
				
		}
		}
		
		return false;
		*/
		
		
		
		
	}

	public void logOut()
	{
		if(ses.getAttribute("username")!=null)
		{
		ses.removeAttribute("username");
		ses.removeAttribute("tip");
		}

	}

	public boolean provjeriLogIn()
	{
		if(ses.getAttribute("username")!=null)
		return true;
		
		return false;
	}
	
	public String dajTip()
	{
		if(ses.getAttribute("tip")!=null)
			return ses.getAttribute("tip").toString();
		
		return null;
	}
	
	
	public void setSession(HttpSession s)
	{
		this.ses = s;
	}
	public HttpSession getSession()
	{
		return ses;
	}
	
}
