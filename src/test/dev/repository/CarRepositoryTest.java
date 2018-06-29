package dev.repository;

import dev.entity.Car;
import dev.entity.CompanyCar;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages ={"dev.config"})
public class CarRepositoryTest {

    @Autowired
    CompanyCarRepository carsRepository ;


    @Test
    public void testUser(){
        CompanyCar car1 = new CompanyCar("LM-888-ER",1,"Citroen","C3","photo1",CompanyCar.CarCategory.BerlinesTailleM);
        CompanyCar car3 = new CompanyCar("OM-888-ER",3,"Focus","T1","photo3",CompanyCar.CarCategory.CitadinesPolyvalentes);

        carsRepository.save(car1);
        carsRepository.save(car3);

        Assertions.assertThat(carsRepository.findAll().contains(car1));
        Assertions.assertThat(carsRepository.findAll().contains(car3));
    }
}
