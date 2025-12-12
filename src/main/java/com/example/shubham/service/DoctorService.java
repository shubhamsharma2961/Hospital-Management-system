package com.example.shubham.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.shubham.models.Doctor;
import com.example.shubham.repository.DoctorRepository;

@Service
public class DoctorService {
	
	private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	public Page<Doctor> getAllDoctors(int page, int size){
		try {
			System.out.println("into service layer");
			Pageable pageable = PageRequest.of(page, size);
			return doctorRepository.findAll(pageable);
		}catch (Exception e) {
			System.out.println("Error message: " + e.getMessage());
			logger.error("an error occurred while fetching the doctors: {}", e.getMessage());
			return null;
		}
	}   
	
	public Doctor getDoctorById(Long id) {
		try {
			Optional<Doctor> doctor = doctorRepository.findById(id);
            return doctor.orElse(null);
		}catch (Exception e) {
			System.out.println("Error message: " + e.getMessage());
			logger.error("an error occurred while fetching the doctor with Id: {}", id, e.getMessage());
			return null;
		}
	}
	
	public Doctor createDoctor(Doctor doctor) {
		try {
			return doctorRepository.save(doctor);
		}catch (Exception e) {
			System.out.println("Error message: " + e.getMessage());
			logger.error("an error occurred while creating doctor: {}", e.getMessage());
			return null;
		}
	}
	
	public void deleteDoctor(Long id) {
		try {
			doctorRepository.deleteById(id);
		}catch (Exception e) {
			System.out.println("Error message: " + e.getMessage());
			logger.error("an error occurred while deleting doctor: {}", e.getMessage());
		}
	}
	
	public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
		try {
			Optional<Doctor> existingDoctor = doctorRepository.findById(id);

            if (existingDoctor.isPresent()) {
                Doctor d = existingDoctor.get();
                d.setName(updatedDoctor.getName());
                d.setSpeciality(updatedDoctor.getSpeciality());
                d.setAge(updatedDoctor.getAge());

                return doctorRepository.save(d);
            } else {
                logger.error("Doctor with ID {} not found", id);
                return null;
            }	
		}catch (Exception e) {
			System.out.println("Error message: " + e.getMessage());
			logger.error("an error occurred while updating doctor: {}", e.getMessage());
			return null;
		}
	}
}
