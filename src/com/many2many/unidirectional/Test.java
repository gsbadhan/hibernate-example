package com.many2many.unidirectional;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.core.HibernateUtil;

@RunWith(JUnit4.class)
public class Test {

	SessionFactory sf;

	@Before
	public void load() {
		HibernateUtil.buildSessionFactory();
		sf = HibernateUtil.getSessionFactory();
	}

	@org.junit.Test
	public void test() {
	newEntry();
	}
	
	
	
	public void newEntry(){
		Session ss = sf.getCurrentSession();
		Transaction trx = ss.beginTransaction();
		Set<Courses> cources=new HashSet<>();
		cources.add(new Courses("dzango"));
		cources.add(new Courses("ruby"));
		cources.add(new Courses("grail"));
		Students students=new Students("har", cources);
		students.setCources(cources);
		ss.save(students);
		trx.commit();
		ss.close();
	}
	

}
