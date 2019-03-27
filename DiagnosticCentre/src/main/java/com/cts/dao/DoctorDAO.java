package com.cts.dao;

import java.security.Principal;

import com.cts.entity.Doctor;


public interface DoctorDAO {
	
	void  saveDoctor(Doctor doctor);
	public Doctor getDoctor(String p);
	
}
