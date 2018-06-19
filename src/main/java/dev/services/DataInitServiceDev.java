package dev.services;

import dev.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class DataInitServiceDev implements DataInitService{

    @PersistenceContext
    private EntityManager em;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    @Override
    public void init(){
        User collab = new User("collab@test",
                passwordEncoder.encode("collab"),
                User.ROLES.COLLAB);
        em.persist(collab);

        User driver = new User("driver@test",
                passwordEncoder.encode("driver"),
                User.ROLES.DRIVER);
        em.persist(driver);

        User admin = new User("admin@test",
                passwordEncoder.encode("admin"),
                User.ROLES.ADMIN);
        em.persist(admin);
    }
}
