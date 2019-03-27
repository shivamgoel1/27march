package com.cts.service;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.dao.DoctorDAO;
import com.cts.entity.Doctor;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	DoctorDAO doctorDAO;

	@Override
	@Transactional
	public void saveDoctor(Doctor doctor) {
		
		doctorDAO.saveDoctor(doctor);
		
	}

	
	@Override
	@Transactional
	public Doctor getDoctor(String p) {
		System.out.println(p+"int the service");
		Doctor doctor=doctorDAO.getDoctor(p);
		return doctor;
	}


}
