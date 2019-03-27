package com.cts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	public Customer(){
		
	}
	
	@Column(name="Customer_Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="First_Name",length=50)
	String first_name;	

	@Column(name="Last_Name",length=50)
	String last_name;	

	@Column(name="Age")
	int age;
		
	@Column(name="Gender",length=50)
	String gender;

	@Column(name="DOB",length=10)
	String dob;	

	@Column(name="Contact_Number",length=50)
	int contact_number;

	@Column(name="Alternate_Contact_Number",length=50)
	int alternate_contact_number;

	@Id
	@Column(name="Email_id",length=50)
	String email_id;

	@Column(name="Password",length=100)
	String password;

	@Column(name="Address_1",length=50)
	String address_1;

	@Column(name="Address_2",length=50)
	String address_2;

	@Column(name="City",length=50)
	String city;

	@Column(name="State",length=50)
	String state;


	@Column(name="Zip_code",length=50)
	String zip_code;


	String authority;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public int getContact_number() {
		return contact_number;
	}


	public void setContact_number(int contact_number) {
		this.contact_number = contact_number;
	}


	public int getAlternate_contact_number() {
		return alternate_contact_number;
	}


	public void setAlternate_contact_number(int alternate_contact_number) {
		this.alternate_contact_number = alternate_contact_number;
	}


	public String getEmail_id() {
		return email_id;
	}


	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress_1() {
		return address_1;
	}


	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}


	public String getAddress_2() {
		return address_2;
	}


	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZip_code() {
		return zip_code;
	}


	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}


	public String getAuthority() {
		return authority;
	}


	public void setAuthority(String authority) {
		this.authority = authority;
	}


	public Customer(int id, String first_name, String last_name, int age, String gender, String dob, int contact_number,
			int alternate_contact_number, String email_id, String password, String address_1, String address_2,
			String city, String state, String zip_code) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.gender = gender;
		this.dob = dob;
		this.contact_number = contact_number;
		this.alternate_contact_number = alternate_contact_number;
		this.email_id = email_id;
		this.password = password;
		this.address_1 = address_1;
		this.address_2 = address_2;
		this.city = city;
		this.state = state;
		this.zip_code = zip_code;
		authority="ROLE_USER";
	}


	public Customer(String first_name, String last_name, int age, String gender, String dob, int contact_number,
			int alternate_contact_number, String email_id, String password, String address_1, String address_2,
			String city, String state, String zip_code) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.gender = gender;
		this.dob = dob;
		this.contact_number = contact_number;
		this.alternate_contact_number = alternate_contact_number;
		this.email_id = email_id;
		this.password = password;
		this.address_1 = address_1;
		this.address_2 = address_2;
		this.city = city;
		this.state = state;
		this.zip_code = zip_code;
		authority="ROLE_USER";
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", age=" + age
				+ ", gender=" + gender + ", dob=" + dob + ", contact_number=" + contact_number
				+ ", alternate_contact_number=" + alternate_contact_number + ", email_id=" + email_id + ", password="
				+ password + ", address_1=" + address_1 + ", address_2=" + address_2 + ", city=" + city + ", state="
				+ state + ", zip_code=" + zip_code + ", authority=" + authority + "]";
	}
	
	
}
