package com.cts.service;

import java.security.Principal;

import com.cts.entity.Doctor;


public interface DoctorService {
	
	void  saveDoctor(Doctor doctor);
	public Doctor getDoctor(String p);
	

}
