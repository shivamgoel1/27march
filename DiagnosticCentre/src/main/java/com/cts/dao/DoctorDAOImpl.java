package com.cts.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.entity.Doctor;

@Repository("doctorDAO")
public class DoctorDAOImpl implements DoctorDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveDoctor(Doctor doctor) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(doctor);
		
	}


	@Override
	public Doctor getDoctor(String id) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println(id+"int he DAOImpl");
		Doctor theDoctor =session.get(Doctor.class,id);
		System.out.println(theDoctor);
		return theDoctor;
		
	}

	
	

}
