package com.cts.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.entity.Admin;
import com.cts.entity.Customer;
import com.cts.entity.UserLogin;
import com.cts.service.AdminService;
import com.cts.service.CustomerService;
import com.cts.service.UserLoginService;

@Controller
public class LoginController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	UserLoginService userLoginService;
	
	
	@GetMapping("/registerCustomer")
	public String showForm(Model model){
		return "customerRegistration";
	}
	@GetMapping("/registerAdmin")
	public String showForm1(Model model){
		return "adminRegistration";
	}
	
	
	@PostMapping("/saveCustomer")
	public String registerCustomer(@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname,
			@RequestParam("age") int age,@RequestParam("gender") String gender,@RequestParam("dob") String dob,
			@RequestParam("contactnumber") int contactnumber,@RequestParam("altcontactnumber") int altcontactnumber,
			@RequestParam("emailid") String emailid,@RequestParam("password") String password,@RequestParam("addressline") String addressline,
			@RequestParam("addressline2") String addressline2,@RequestParam("city") String city,@RequestParam("state") String state,
			@RequestParam("zipcode") String zipcode
			){
		 String encoded=new BCryptPasswordEncoder().encode(password);
		 Customer customer= new Customer( firstname, lastname, age, gender, dob, contactnumber, altcontactnumber, emailid, encoded, addressline, addressline2, city, state, zipcode);
		 System.out.println(customer);
		 UserLogin login= new UserLogin(emailid,encoded,customer.getAuthority());
		 userLoginService.registerUser(login);
		 customerService.registerUser(customer);
		return "login";
	}
	
	@PostMapping("/saveAdmin")
	public String registerAdmin(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastname,
			@RequestParam("age") int age,@RequestParam("gender") String gender,@RequestParam("dob") String dob,
			@RequestParam("contactNumber") int contactnumber,@RequestParam("altcontactNumber") int altcontactnumber,
			@RequestParam("emailid") String emailid,@RequestParam("password") String password){
				
			String encoded=new BCryptPasswordEncoder().encode(password);
			Admin admin= new Admin(firstName,lastname,age,gender,dob,contactnumber,altcontactnumber,emailid,password);
			UserLogin login= new UserLogin(emailid,encoded,admin.getAuthority());
			userLoginService.registerUser(login);
			adminService.registerUser(admin);
			return "login";
		}
	
	
	
    @RequestMapping(value="/logout", method=RequestMethod.GET)  
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
         return "redirect:/login";  
     }  
	
}
