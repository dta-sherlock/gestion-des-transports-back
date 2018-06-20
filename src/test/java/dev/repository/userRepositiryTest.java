package dev.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.config.DataSourceMySQLConfig;
import dev.config.ServicesConfig;
import dev.entity.Car;
import dev.entity.Car.CarCategory;

@ContextConfiguration(classes = { ServicesConfig.class, DataSourceMySQLConfig.class })
@RunWith(SpringRunner.class)
@DataJpaTest
public class userRepositiryTest {

	@Autowired
	CarsRepository carsRepository;

	@Test
	public void carsRepositoryTest() {
		Car car1 = new Car("TT-789-LL", "car1", 4, "Citroen", "Berlingo", CarCategory.CitadinesPolyvalentes);

		carsRepository.save(car1);

		assertThat(carsRepository.findAll().contains(car1));

	}

}
