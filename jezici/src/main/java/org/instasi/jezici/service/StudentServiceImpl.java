package org.instasi.jezici.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import org.instasi.jezici.dao.StudentDao;
import org.instasi.jezici.models.Student;

public class StudentServiceImpl implements StudentService {
	
	private StudentDao studentDao;


	@Override
	@Transactional
	public void dodajStudenta(Student s) {
		this.getStudentDao().dodajStudenta(s);
	}

	@Override
	@Transactional
	public void updateStudenta(Student s) {
		this.getStudentDao().updateStudenta(s);
	}

	@Override
	@Transactional
	public List<Student> listaStudenata() {
		return this.getStudentDao().listaStudenata();
	}

	@Override
	@Transactional
	public Student dajStudentaPoIdu(int id) {
		return this.getStudentDao().dajStudentaPoIdu(id);
	}
	
	@Override
	@Transactional
	public List<Student> dajStudentaPoIdu(String korisnickoIme, String sifra) {
		return this.getStudentDao().dajStudentaPoKorisnickomImenu(korisnickoIme, sifra);
	}

	@Override
	@Transactional
	public void obrisiStudenta(int id) {
		this.getStudentDao().obrisiStudenta(id);
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

}
