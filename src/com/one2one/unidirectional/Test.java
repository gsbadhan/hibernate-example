package com.one2one.unidirectional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		Session ss=sf.getCurrentSession();
		org.hibernate.Transaction trx=ss.beginTransaction();
		//Student student=ss.get(Student.class, 101);
		//StudentInfo studentInfo=new StudentInfo("betch", "a", student);
		//ss.save(studentInfo);
		StudentInfo studentInfo=ss.get(StudentInfo.class, 101);
		ss.delete(studentInfo);
		trx.commit();
		ss.close();
		
	}

}
