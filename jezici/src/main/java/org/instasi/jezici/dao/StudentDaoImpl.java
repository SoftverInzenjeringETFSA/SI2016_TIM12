package org.instasi.jezici.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.instasi.jezici.models.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override 
	public void dodajStudenta(Student s){
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(s);
		logger.info("Student uspjesno dodan "+s);
	}
	
	@Override
	public void updateStudenta(Student s){
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(s);
		logger.info("Student uspjesno updateovan "+s);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> listaStudenata() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Student> listaStudenata = session.createQuery("from Student").list();
		for(Student p : listaStudenata){
			logger.info("Student List::"+p);
		}
		return listaStudenata;
	}
	
	@Override
	public Student dajStudentaPoIdu(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Student s = (Student) session.load(Student.class, new Integer(id));
		logger.info("Student loaded successfully, Student details="+s);
		return s;
	}
	
	@Override
	public List<Student> dajStudentaPoKorisnickomImenu(String korisnickoIme, String sifra) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Student where korisnickoIme = :korisnickoIme and sifra = :sifra");
		query.setParameter("korisnickoIme", korisnickoIme);
		query.setParameter("sifra", sifra);
		List<Student> listaStudenata =  query.list();
		return listaStudenata;
		
		
	}
	
	@Override
	public void obrisiStudenta(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Student s = (Student) session.load(Student.class, new Integer(id));
		if(null != s){
			session.delete(s);
		}
		logger.info("Student deleted successfully, student details="+s);
	}
	

}
