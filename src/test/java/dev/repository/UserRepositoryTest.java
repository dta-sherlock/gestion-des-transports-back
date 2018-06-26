package dev.repository;

import dev.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = "dev.config")
@Profile("dev-mysql")
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Test
    public void testUser(){
        User collab = new User("collab@test",
                "collab",
                User.ROLES.COLLAB);
        userRepository.save(collab);

        User driver = new User("driver@test",
                "driver",
                User.ROLES.DRIVER);
        userRepository.save(driver);

        User admin = new User("admin@test",
                "admin",
                User.ROLES.ADMIN);
        userRepository.save(admin);

        userRepository.save(collab);
        userRepository.save(driver);
        userRepository.save(admin);

        assertTrue(userRepository.findAll().contains(collab));
        assertTrue(userRepository.findAll().contains(driver));
        assertTrue(userRepository.findAll().contains(admin));
    }
}
