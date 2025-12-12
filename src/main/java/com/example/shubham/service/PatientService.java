package com.example.shubham.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.shubham.models.Patient;
import com.example.shubham.repository.PatientRepository;

@Service
public class PatientService {
	
	private static final Logger logger = LoggerFactory.getLogger(PatientService.class);
	@Autowired
	private PatientRepository patientRepository; 
	
	public Page<Patient> getAllPatients(int page, int size){
		try {
			System.out.println("into service layer");
			Pageable pageable = PageRequest.of(page, size);
			return patientRepository.findAll(pageable);
		}catch (Exception e) {
			System.out.println("Error message: " + e.getMessage());
			logger.error("an error occurred while fetching the patients: {}", e.getMessage());
			return null;
		}
	}
	
	public Patient getPatientById(Long id) {
		try {
			Optional<Patient> patient = patientRepository.findById(id);
			return patient.orElse(null);
		}catch (Exception e) {
			System.out.println("Error message: " + e.getMessage());
			logger.error("an error occurred while fetching patient with Id {} : {}", id, e.getMessage());
			return null;
		}
	}
	
	public Patient createPatient(Patient patient) {
		try {
			patientRepository.save(patient);
			return patient;
		}catch (Exception e) {
			System.out.println("Error message: " + e.getMessage());
			logger.error("an error occurred while creating patient: {}", e.getMessage());
			return null;
		}
	}
	
	public void deletePatient(Long id) {
		try {
			patientRepository.deleteById(id);
		}catch (Exception e) {
			System.out.println("Error message: " + e.getMessage());
			logger.error("an error occurred while deleting patient: {}", e.getMessage());
		}
	}
	
	public Patient updatePatient(Long id, Patient updatedPatient) {
		try {
			Optional<Patient> existingPatient = patientRepository.findById(id);
			if(existingPatient.isPresent()) {
				Patient p = existingPatient.get();
				p.setName(updatedPatient.getName());
				p.setAge(updatedPatient.getAge());
				p.setGender(updatedPatient.getGender());
				patientRepository.save(p);
				
				return updatedPatient; 
			}else {
				logger.error("Patient with ID {} not found", id);
				return null;
			}
		}catch (Exception e) {
			System.out.println("Error message: " + e.getMessage());
			logger.error("an error occurred while updating patient: {}", e.getMessage());
			return null;
		}
	}
}
