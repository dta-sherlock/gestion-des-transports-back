package dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.entity.CompanyCarBooking;
import dev.repository.CompanyCarBookingRepository;

@RestController
@RequestMapping("/collaborateur/reservations")
@CrossOrigin
public class BookingController {

	@Autowired
	CompanyCarBookingRepository companyCarBookingRepo;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@Secured({})
	public List<CompanyCarBooking> getCompanyCarBookings() {
		return companyCarBookingRepo.findAll();
	}

	@RequestMapping(value = "/creer", method = RequestMethod.POST)
	@Secured({})
	public void saveCompanyCarBooking(@ModelAttribute("companyCarBooking") CompanyCarBooking companyCarBooking) {
		companyCarBookingRepo.save(companyCarBooking);
	}
}
