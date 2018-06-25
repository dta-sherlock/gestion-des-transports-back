package dev.repository;

import dev.entity.Booking;
import dev.entity.User;
import dev.entity.User.ROLES;
import dev.services.DataInitServiceDev;
import org.assertj.core.api.Assertions;
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

	@Autowired
	private DataInitServiceDev dataInitServiceDev;

	@Test
	public void testBooking() {
		
		User user = new User("test@mail.com", "123456789", ROLES.COLLAB);
		Booking booking = new Booking(user, LocalDateTime.now(), LocalDateTime.now().plusDays(1));

		dataInitServiceDev.init();
		
		bookingRepo.save(booking);

		bookingRepo.findAll().forEach(booking1 -> System.out.println(booking1.getId()));

		Assertions.assertThat(bookingRepo.findAll().contains(booking));
	}
}
