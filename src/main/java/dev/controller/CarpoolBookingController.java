package dev.controller;

import dev.entity.CarpoolBooking;
import dev.repository.CarpoolBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carpoolBookings")
@CrossOrigin
public class CarpoolBookingController {

    @Autowired
    CarpoolBookingRepository carpoolBookingRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
//    @Secured({})
    public List<CarpoolBooking> getBookings() {
        return carpoolBookingRepository.findAll();
    }

}
