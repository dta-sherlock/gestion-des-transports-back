package dev.services;

import dev.entity.User;
import dev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class DataInitServiceDev implements DataInitService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void init(){
        User collab = new User("collab@test",
                passwordEncoder.encode("collab"),
                User.ROLES.COLLAB);
        userRepository.save(collab);

        User driver = new User("driver@test",
                passwordEncoder.encode("driver"),
                User.ROLES.DRIVER);
        userRepository.save(driver);

        User admin = new User("admin@test",
                passwordEncoder.encode("admin"),
                User.ROLES.ADMIN);
        userRepository.save(admin);
    }
}