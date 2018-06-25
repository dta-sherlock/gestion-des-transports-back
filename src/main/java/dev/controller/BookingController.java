package dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entity.CompanyCarBooking;

@RestController
@RequestMapping("/reservations")
@CrossOrigin
public class BookingController {
	
	@Autowired
	private CompanyCarBooking companyCarBookingRepo;
	
	
}
