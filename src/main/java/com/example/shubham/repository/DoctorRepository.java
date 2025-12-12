package com.example.shubham.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.shubham.models.Doctor;

@Repository

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

}
