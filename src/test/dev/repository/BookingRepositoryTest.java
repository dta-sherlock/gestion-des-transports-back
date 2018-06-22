package dev.repository;

import dev.entity.Booking;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = "dev.config")
@Profile("dev-mysql")
public class BookingRepositoryTest {

    @Autowired
    private BookingRepository bookingRepo;

    @Test
    public void testBooking() {

        Booking booking = new Booking(LocalDateTime.now(), LocalDateTime.now().plusDays(1));

        bookingRepo.save(booking);

        assertTrue()
    }
}
