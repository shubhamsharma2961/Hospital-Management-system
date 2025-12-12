package com.example.shubham.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.shubham.models.Bill;

@Repository

public interface BillRepository extends JpaRepository<Bill, Long>{

}
