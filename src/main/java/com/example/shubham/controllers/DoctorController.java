package com.example.shubham.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.shubham.models.Doctor;
import com.example.shubham.service.DoctorService;


@RestController
@RequestMapping("/api/v1/Doctors")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping
	public Page<Doctor> getAllDoctors(@RequestParam(name= "page", defaultValue = "0")int page, 
									  @RequestParam(name= "size", defaultValue = "2")int size){
		System.out.println("Fetching the Doctors");
		return doctorService.getAllDoctors(page, size);
	}
	
	@PostMapping
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		System.out.println("Creating Doctor");
		return doctorService.createDoctor(doctor);
	}
	
	@GetMapping("/{id}")
	public Doctor getDoctorById(@PathVariable long id) {
		System.out.println("Fetching Doctor by ID:" + id);
		return doctorService.getDoctorById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDoctor(@PathVariable long id) {
		System.out.println("Deleting Doctor with ID:" + id);
		doctorService.deleteDoctor(id);
	}
	
	@PutMapping("/{id}")
	public void updateDoctor(@PathVariable long id, @RequestBody Doctor doctor) {
		System.out.println("Updating Doctor with ID:" + id);
		doctorService.updateDoctor(id, doctor);
	}
}
