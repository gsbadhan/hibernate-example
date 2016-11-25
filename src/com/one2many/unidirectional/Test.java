package com.one2many.unidirectional;

import java.util.ArrayList;
import java.util.List;

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
		Address address=ss.get(Address.class, 10);
		List<Employee> employees=new ArrayList<>();
		employees.add(new Employee("devi", address));
		employees.add(new Employee("suman", address));
		address.setEmployee(employees);
		ss.save(address);
		trx.commit();
		ss.close();

	}

}
