package dev.repository;

import dev.services.DataInitServiceDev;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackages = "dev.config")
public class DataInitServiceTest {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private DataInitServiceDev dataInitServiceDev;

    @Test
    public void initTest(){
        int nbStart = userRepository.findAll().size();

        dataInitServiceDev.init();
        assertTrue(userRepository.findAll().size()!=nbStart);
        assertTrue(userRepository.findAll().size()==(nbStart+3));

    }
}
