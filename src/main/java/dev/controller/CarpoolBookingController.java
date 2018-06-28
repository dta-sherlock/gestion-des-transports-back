package dev.controller;

import dev.entity.CarpoolBooking;
import dev.repository.CarpoolBookingRepository;
import dev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carpoolBookings")
@CrossOrigin
public class CarpoolBookingController {

    @Autowired
    CarpoolBookingRepository carpoolBookingRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    // TODO @Secured({})
    public List<CarpoolBooking> getBookings() {
        return carpoolBookingRepository.findAll();
    }

//    @RequestMapping(value = "/user/{userEmail}", method = RequestMethod.GET)
//    // TODO @Secured({})
//    public List<CarpoolBooking> getBookingsByUserEmail(@PathVariable String userEmail) {
//        return carpoolBookingRepository.findByUser(userRepository.findByEmail(userEmail));
//    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addCarpoolBooking(@RequestBody CarpoolBooking carpoolBooking){
        carpoolBookingRepository.save(carpoolBooking);
    }

}
