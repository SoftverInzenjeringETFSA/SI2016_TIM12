package org.instasi.jeziki.springbootstarter.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.instasi.jeziki.springbootstarter.models.Predavac;
import org.instasi.jeziki.springbootstarter.models.Student;
import org.instasi.jeziki.springbootstarter.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.instasi.springbootstarter.*;

@Service
public class StudentService {
	
	private Date datum = new Date();
	@Autowired
	private StudentRepository studentRepository;


	
	public List<Student> prikaziStudente()
	{
		List<Student> lista= new ArrayList<>();
		studentRepository.findAll().forEach(lista::add);
		return lista;
	}
	
	public void dodajStudenta(Student s)
	{
		studentRepository.save(s);
	}
	
	public void obrisiStudenta(int id)
	{
		studentRepository.delete(id);		
	}
	
	public void obrisiStudenta(Student id)
	{
		studentRepository.delete(id);		
	}
	public Student dajStudenta(int id)
	{
		return studentRepository.findOne(id);
	}
	
	public void updateStudenta(int id, Student s)
	{
		studentRepository.save(s);
	}
	public Iterable<Student> dajStudentaPoImenuPrezimenu(String ime,String prezime)
	{
		return studentRepository.nadjiStudentaPoImenuPrezimenu(ime, prezime);
	}
	
	
	public Student dajStudentaPoUsername(String username)
	{
		List<Student> studenti = (List<Student>) studentRepository.nadjiStudentaPoUsername(username);
		return studenti.get(0);
	}
	
	

}
