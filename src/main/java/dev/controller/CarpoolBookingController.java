package dev.controller;

import dev.entity.CarpoolBooking;
import dev.repository.CarpoolBookingRepository;
import dev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// TODO change to @RequestMapping("/rest/carpoolBookings") when authentication fully works in front application
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

    @RequestMapping(value = "/user/{userEmail}", method = RequestMethod.GET)
    // TODO @Secured({})
    public List<CarpoolBooking> getBookingsByUserEmail(@PathVariable String userEmail) {
        return carpoolBookingRepository.findByCreator(userRepository.findByEmail(userEmail));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    // TODO @Secured({})
    public void addCarpoolBooking(@RequestBody CarpoolBooking carpoolBooking){
        carpoolBookingRepository.save(carpoolBooking);
    }

    @RequestMapping(value = "/addUserToBooking", method = RequestMethod.POST)
    // TODO @Secured({})
    public void addUserToCarpoolBooking(@RequestBody List<Integer> idTable){
        int userId = idTable.get(0);
        int bookingId = idTable.get(1);
        CarpoolBooking booking = carpoolBookingRepository.findById(bookingId);
        booking.addPassenger(userRepository.findById(userId));
        carpoolBookingRepository.save(booking);
    }

}
