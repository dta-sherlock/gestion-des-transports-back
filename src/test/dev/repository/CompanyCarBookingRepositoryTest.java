package dev.repository;

import java.time.LocalDateTime;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import dev.entity.Car;
import dev.entity.CompanyCarBooking;
import dev.entity.Car.CarCategory;
import dev.services.DataInitServiceDev;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = "dev.config")
@Profile("dev-mysql")
public class CompanyCarBookingRepositoryTest {

	@Autowired
	private CompanyCarBookingRepository companyCarBookingRepo;

	@Autowired
	private DataInitServiceDev dataInitServiceDev;

	@Test
	public void testCompanyCarBooking() {

		Car car = new Car("AA-123-BB", "photo_test", 4, "Peugeot", "123", CarCategory.BerlinesTailleL);
		CompanyCarBooking companyCarBooking = new CompanyCarBooking(LocalDateTime.now(),
				LocalDateTime.now().plusDays(1), car);

		dataInitServiceDev.init();
		companyCarBookingRepo.save(companyCarBooking);

		companyCarBookingRepo.findAll().forEach(booking1 -> System.out.println(booking1.getId()));

		Assertions.assertThat(companyCarBookingRepo.findAll().contains(companyCarBooking));
	}
}
