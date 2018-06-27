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

import dev.entity.CompanyCarBooking;
import dev.entity.User;
import dev.entity.CompanyCar;
import dev.entity.User.ROLES;
import dev.services.DataInitServiceDev;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = "dev.config")
@Profile("dev-mysql")
public class CompanyCarBookingRepositoryTest {

	@Autowired
	private CompanyCarBookingRepository companyCarBookingRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CompanyCarRepository companyCarRepo;

	@Autowired
	private DataInitServiceDev dataInitServiceDev;

	@Test
	public void testCompanyCarBooking() {

		User user = new User("test@mail.com", "123456789", ROLES.COLLAB);
		CompanyCar companyCar = new CompanyCar("AA-123-BB", 4, "marque", "modèle", "photo",
				CompanyCar.CarCategory.BerlinesTailleL);
		CompanyCarBooking companyCarBooking = new CompanyCarBooking(user, LocalDateTime.now(),
				LocalDateTime.now().plusDays(1), companyCar);

		dataInitServiceDev.init();

		companyCarRepo.save(companyCar);
		userRepo.save(user);
		companyCarBookingRepo.save(companyCarBooking);

		Assertions.assertThat(companyCarBookingRepo.findAll().contains(companyCarBooking));
	}
}
