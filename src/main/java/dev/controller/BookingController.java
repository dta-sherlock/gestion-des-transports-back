package dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.entity.Booking;
import dev.repository.BookingRepository;

@RestController
@RequestMapping("/bookings")
@CrossOrigin
public class BookingController {

	@Autowired
	BookingRepository bookingRepo;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@Secured({})
	public List<Booking> getBookings() {
		return bookingRepo.findAll();
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	@Secured({})
	public void saveBooking(@ModelAttribute("booking") Booking booking) {
		bookingRepo.save(booking);
	}
}
