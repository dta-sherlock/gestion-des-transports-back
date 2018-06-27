package dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.entity.CompanyCarBooking;
import dev.entity.User;
import dev.repository.CompanyCarBookingRepository;
import dev.repository.UserRepository;

@RestController
@RequestMapping("/collaborateur/reservations")
@CrossOrigin
public class BookingController {

	@Autowired
	CompanyCarBookingRepository companyCarBookingRepo;
	
	@Autowired
	UserRepository userRepo;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@Secured({})
	public List<CompanyCarBooking> listCompanyCarBookings() {
		return companyCarBookingRepo.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@Secured({})
	public List<CompanyCarBooking> listCompanyCarBookingsByCreator(@PathVariable int id) {
		User creator = userRepo.findOne(id);
		return companyCarBookingRepo.findByCreator(creator);
	}

	@RequestMapping(value = "/creer", method = RequestMethod.POST)
	@Secured({})
	public void saveCompanyCarBooking(@ModelAttribute("companyCarBooking") CompanyCarBooking companyCarBooking) {
		companyCarBookingRepo.save(companyCarBooking);
	}
}
