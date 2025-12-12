package com.example.shubham.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.shubham.models.Bill;
import com.example.shubham.repository.BillRepository;

@Service
public class BillService {

    private static final Logger logger = LoggerFactory.getLogger(BillService.class);

    @Autowired
    private BillRepository billRepository;

    public Page<Bill> getAllBills(int page, int size) {
        try {
            System.out.println("into service layer");
            Pageable pageable = PageRequest.of(page, size);
            return billRepository.findAll(pageable);
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while fetching the bills: {}", e.getMessage());
            return null;
        }
    }

    public Bill getBillById(Long id) {
        try {
            Optional<Bill> bill = billRepository.findById(id);
            return bill.orElse(null);
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while fetching the bill by Id: {} - {}", id, e.getMessage());
            return null;
        }
    }

    public Bill createBill(Bill bill) {
        try {
            return billRepository.save(bill);
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while creating bill: {}", e.getMessage());
            return null;
        }
    }

    public void deleteBill(Long id) {
        try {
            billRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while deleting bill: {}", e.getMessage());
        }
    }

    public Bill updateBill(Long id, Bill updatedBill) {
        try {
            Optional<Bill> existingBill = billRepository.findById(id);

            if (existingBill.isPresent()) {
                Bill b = existingBill.get();
                b.setAmount(updatedBill.getAmount());
                b.setPatientId(updatedBill.getPatientId());
                b.setStatus(updatedBill.getStatus());

                return billRepository.save(b);
            } else {
                logger.error("Bill with ID {} not found", id);
                return null;
            }

        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while updating bill: {}", e.getMessage());
            return null;
        }
    }
}
