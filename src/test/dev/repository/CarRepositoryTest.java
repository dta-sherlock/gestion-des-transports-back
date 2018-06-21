package dev.repository;

import dev.entity.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackages ={"dev.config"})
@Profile({"dev-mysql"})
public class CarRepositoryTest {

    @Autowired
    CarRepository carsRepository ;


    @Test
    public void testUser(){

        Car car1 = new Car( "LM-888-UI", "photo1",2,"Peugot","C1",Car.CarCategory.BerlinesTailleM);
        Car car2 = new Car( "LM-888-OP", "photo2",3,"Peugot","C2",Car.CarCategory.BerlinesTailleS);
        Car car3 = new Car( "LM-888-AZ", "photo3",4,"Peugot","C3",Car.CarCategory.BerlinesTailleL);

        carsRepository.save(car1);

        carsRepository.save(car2);
        carsRepository.save(car3);

        assertTrue(carsRepository.findAll().contains(car1));
        assertTrue(carsRepository.findAll().contains(car2));
        assertTrue(carsRepository.findAll().contains(car3));
    }
}
