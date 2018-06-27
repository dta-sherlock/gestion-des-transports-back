package dev.repository;

import dev.entity.Car;
import dev.entity.CarpoolBooking;
import dev.entity.User;
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
public class testCarpoolBookingRepository {

	@Autowired
	CarpoolBookingRepository cpbRepo;

	@Test
	public void testCbRepo (){
		Car car1 = new Car("XX-123-GO", 4, "Peugeot", "5008");
		User creator = new User();
		CarpoolBooking cb = new CarpoolBooking(creator, LocalDateTime.now(), LocalDateTime.now(),"7 Rue des Champs", "8 Rue des Hirondelles", 8, car1);
		this.cpbRepo.save(cb);
		Assertions.assertThat(cpbRepo.findAll().contains(cb));
	}
}


