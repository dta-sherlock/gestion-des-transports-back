package dev.controller;

import java.util.List;

import dev.entity.CarpoolBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.repository.CarpoolBookingRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("collaborateur/annonces/")
public class CarpoolBookingController {

	@Autowired
	private CarpoolBookingRepository cpbRepo;

	@GetMapping
	public List<CarpoolBooking> findAllCarpoolBooking() {
		return this.cpbRepo.findAll();
	}

	@PostMapping(path = "/creer")
	public void submitCarpoolBooking(@RequestBody CarpoolBooking carpoolBooking) {
		this.cpbRepo.save(carpoolBooking);
	}
}
