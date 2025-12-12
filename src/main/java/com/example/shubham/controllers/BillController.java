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

import com.example.shubham.models.Bill;
import com.example.shubham.service.BillService;


@RestController
@RequestMapping("/api/v1/Bills")
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@GetMapping
	public Page<Bill> getAllBills(@RequestParam(name= "page", defaultValue = "0")int page, 
			                      @RequestParam(name= "size", defaultValue = "2")int size){
		System.out.println("Fetching the Bills");
		return billService.getAllBills(page, size);
	}
	
	@PostMapping
	public Bill createBill(@RequestBody Bill bill) {
		System.out.println("Creating Bill");
		return billService.createBill(bill);
	}
	
	@GetMapping("/{id}")
	public Bill getBillById(@PathVariable long id) {
		System.out.println("Fetching Bill by ID:" + id);
		return billService.getBillById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBill(@PathVariable long id) {
		System.out.println("Deleting Bill with ID:" + id);
		billService.deleteBill(id);
	}
	
	@PutMapping("/{id}")
	public void updateBill(@PathVariable long id, @RequestBody Bill bill) {
		System.out.println("Updating Bill with ID:" + id);
		billService.updateBill(id, bill);
	}
}
