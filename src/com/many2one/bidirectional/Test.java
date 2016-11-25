package com.many2one.bidirectional;

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
		Session ss = sf.getCurrentSession();
		Transaction trx = ss.beginTransaction();
		Address address=new Address("up");
		Set<Employee> employees=new HashSet<>();
		employees.add(new Employee("xx",address));
		employees.add(new Employee("yy",address));
		employees.add(new Employee("zz",address));
		address.setEmployees(employees);
		ss.save(address);
		trx.commit();
		ss.close();
		
	}
	
	private void addExisting(){
		Session ss = sf.getCurrentSession();
		Transaction trx = ss.beginTransaction();
		Employee employee = new Employee("rs", ss.get(Address.class, 1));
		ss.save(employee);
		trx.commit();
		ss.close();
	}
	
	private void addNewAddress(){
		Address address = new Address("banglore");
		Employee employee = new Employee("rs", address);
		Session ss = sf.getCurrentSession();
		Transaction trx = ss.beginTransaction();
		ss.save(employee);
		trx.commit();
		ss.close();
	}
	
	private void delete(){
		Session ss = sf.getCurrentSession();
		Transaction trx = ss.beginTransaction();
		Employee employee = ss.get(Employee.class, 5);
		ss.delete(employee);
		trx.commit();
		ss.close();
	}

}
