package dev.services;

import dev.entity.Car;
import dev.entity.CarpoolBooking;
import dev.entity.User;
import dev.repository.CarRepository;
import dev.repository.CarpoolBookingRepository;
import dev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class DataInitServiceDev implements DataInitService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    CarpoolBookingRepository carpoolBookingRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void init(){
        User collab = new User("collab@test",
                passwordEncoder.encode("collab"),
                User.ROLES.COLLAB);
        userRepository.save(collab);

        Car car = new Car("XX-123-XX", 4, "Peugeot", "206");
        carRepository.save(car);

        CarpoolBooking carpool1 = new CarpoolBooking(collab, LocalDateTime.now(), LocalDateTime.now().plusHours(2),
                "5 impasse Jacques Brel", "7 Avenue Jacques Cartier", 3, car);
        carpoolBookingRepository.save(carpool1);

    }
}