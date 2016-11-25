package com.one2one.bidirectional;

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
		Session ss = sf.getCurrentSession();
		org.hibernate.Transaction trx = ss.beginTransaction();
		Student student = new Student(102, "rs");
		StudentInfo studentInfo = new StudentInfo("mtech", "b", student);
		student.setStudentInfo(studentInfo);
		ss.save(student);
		trx.commit();
		ss.close();

	}

}
