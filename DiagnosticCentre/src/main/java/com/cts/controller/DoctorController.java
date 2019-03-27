package com.cts.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.entity.Doctor;
import com.cts.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	
	
	@PostMapping("/saveDoctor")
	public String saveDoctorDetails(@ModelAttribute("doctor") Doctor theDoctor)
	{
		doctorService.saveDoctor(theDoctor);;
		return "redirect:/doctor/doctorhome";
	}
	

	@GetMapping("/updateDoctor")
	public String showDoctorUpdateForm(@RequestParam("doctorId") String theId , Model model)
	{
		System.out.println("ye rahi ID :"+theId);
	    Doctor theDoctor=doctorService.getDoctor(theId);
		model.addAttribute("doctor",theDoctor);
		return "doctorUpdate";
	}
	

	@GetMapping("/doctorhome")
	public String showDoctor(Principal principal , Model model)
	{
		String username = principal.getName();
		System.out.println(username);
		Doctor theDoctor=doctorService.getDoctor(username);
		model.addAttribute("doctor",theDoctor);
		return "doctorHome";
	}



}
