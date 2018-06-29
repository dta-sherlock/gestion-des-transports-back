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
                User.ROLES.COLLAB,"UserCollab","DTA");
        userRepository.save(collab);

        User driver = new User("driver@test",
                passwordEncoder.encode("driver"),
                User.ROLES.DRIVER,"userDriver","DTA");
        userRepository.save(driver);

        User admin = new User("admin@test",
                passwordEncoder.encode("admin"),
                User.ROLES.ADMIN,"userAdmin","DTA");
        userRepository.save(admin);

        Car car = new Car("XX-123-XX", 4, "Peugeot", "206");
        carRepository.save(car);

        CarpoolBooking carpool1 = new CarpoolBooking(collab, LocalDateTime.now(), LocalDateTime.now().plusHours(2),
                "5 impasse Jacques Brel", "7 Avenue Jacques Cartier", 3, car);
        carpoolBookingRepository.save(carpool1);

        CarpoolBooking carpool12 = new CarpoolBooking(driver, LocalDateTime.now(), LocalDateTime.now().plusHours(2),
                "7 Avenue Jacques Cartier", "5 impasse Jacques Brel", 1, car);
        carpoolBookingRepository.save(carpool12);
    }
}