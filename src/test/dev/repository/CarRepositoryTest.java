package dev.repository;

import dev.entity.Vehicules;
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
    CarRepository carsRepository ;


    @Test
    public void testUser(){

        Vehicules car1 = new Vehicules( "LM-888-UI", "photo1",2,"Peugot","C1",Vehicules.CarCategory.BerlinesTailleM);
        Vehicules car2 = new Vehicules( "LM-888-OP", "photo2",3,"Peugot","C2",Vehicules.CarCategory.BerlinesTailleS);
        Vehicules car3 = new Vehicules( "LM-888-AZ", "photo3",4,"Peugot","C3",Vehicules.CarCategory.BerlinesTailleL);

        carsRepository.save(car1);

        carsRepository.save(car2);
        carsRepository.save(car3);

        Assertions.assertThat(carsRepository.findAll().contains(car1));
        Assertions.assertThat(carsRepository.findAll().contains(car2));
        Assertions.assertThat(carsRepository.findAll().contains(car3));
    }
}
