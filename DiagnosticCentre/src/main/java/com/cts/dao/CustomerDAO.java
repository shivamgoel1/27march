package com.cts.dao;

import java.util.List;

import com.cts.entity.Customer;
import com.cts.entity.Doctor;
import com.cts.entity.Services;

public interface CustomerDAO {
 public List<Services> serviceList();
 public List<Doctor> doctorList();
	public void registerUser(Customer customer);
	public Customer getCustomer(String p);
}
