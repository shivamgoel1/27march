package com.cts.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.entity.Customer;
import com.cts.entity.Doctor;
import com.cts.entity.Services;
import com.cts.service.CustomerService;
import com.cts.service.UserLoginService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	UserLoginService userLoginService;
	
	@GetMapping("/servicelist")
	public String serviceList(Model model,Principal principal) {
		
		String username= principal.getName();
		List<Services> list = customerService.serviceList();
		Customer customer = customerService.getCustomer(username);
		System.out.println("service"+list);
		model.addAttribute("customer", customer);
		model.addAttribute("service",list);
		return "CustomerHome";
	}
	
	@GetMapping("/doctorList")
public String doctorList(Model model) {
		
		List<Doctor> list = customerService.doctorList();
		System.out.println("doctor"+list);
		model.addAttribute("doctor",list);
		return "index";
	}
	
}
