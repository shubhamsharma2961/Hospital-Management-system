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

import com.example.shubham.models.Appointment;
import com.example.shubham.service.AppointmentService;

@RestController
@RequestMapping("/api/v1/Appointments")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@GetMapping
	public Page<Appointment> getAllAppointments(@RequestParam(name= "page", defaultValue = "0")int page, 
			                                    @RequestParam(name= "size", defaultValue = "2")int size){
		System.out.println("Fetching the Appointments");
		return appointmentService.getAllAppointment(page, size);
	}
	
	@PostMapping
	public Appointment createAppointment(@RequestBody Appointment appointment) {
		System.out.println("Creating Appointment");
		return appointmentService.createAppointment(appointment);
	}
	
	@GetMapping("/{id}")
	public Appointment getAppointmentById(@PathVariable long id) {
		System.out.println("Fetching Appointment by ID:" + id);
		return appointmentService.getAppointmentById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAppointment(@PathVariable long id) {
		System.out.println("Deleting Appointment with ID:" + id);
		appointmentService.deleteAppointment(id);
	}
	
	@PutMapping("/{id}")
	public void updateAppointment(@PathVariable long id, @RequestBody Appointment appointment) {
		System.out.println("Updating Appointment with ID:" + id);
		appointmentService.updateAppointment(id, appointment);
	}

}
