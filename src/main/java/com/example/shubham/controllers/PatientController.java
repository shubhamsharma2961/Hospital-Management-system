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

import com.example.shubham.models.Patient;
import com.example.shubham.service.PatientService;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping
	public Page<Patient> getAllPatients(@RequestParam(name= "page", defaultValue = "0")int page, 
										@RequestParam(name= "size", defaultValue = "2")int size){
		System.out.println("Fetching the Patients");
		return patientService.getAllPatients(page, size);
	}
	
	@PostMapping
	public Patient createPatient(@RequestBody Patient patient) {
		System.out.println("Creating Patient");
		return patientService.createPatient(patient);
	}
	
	@GetMapping("/{id}")
	public Patient getPatientById(@PathVariable long id) {
		System.out.println("Fetching Patient by ID:"  + id);
		return patientService.getPatientById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deletePatient(@PathVariable long id) {
		System.out.println("Deleting Patient with ID:" + id);
		patientService.deletePatient(id);
	}
	
	@PutMapping("/{id}")
	public Patient updatePatient(@PathVariable long id, @RequestBody Patient patient) {
		System.out.println("Updating Patient with ID:" + id);
		return patientService.updatePatient(id, patient);
	}
}
