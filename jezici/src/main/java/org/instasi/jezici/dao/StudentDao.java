package org.instasi.jezici.dao;

import java.util.List;

import org.instasi.jezici.models.Student;



public interface StudentDao{
	
	public void dodajStudenta(Student s);
	public void updateStudenta(Student s);
	public List<Student> listaStudenata();
	public Student dajStudentaPoIdu(int id);
	public void obrisiStudenta(int id);
	public List<Student> dajStudentaPoKorisnickomImenu(String korisnickoIme, String sifra);
	

}
