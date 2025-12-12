package com.example.shubham.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.shubham.models.Patient;

@Repository

public interface PatientRepository extends JpaRepository<Patient, Long> {
	

}
