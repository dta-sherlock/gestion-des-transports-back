package dev.repository;

import dev.entity.Annonce;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.time.LocalDateTime;


@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = "dev.config")
@Profile("dev-mysql")
public class testAnnonceRepository {

	@Autowired
	AnnonceRepository annonceRepo;

	@Test
	public void testAnnonce (){
		Annonce a1 = new Annonce("7 Rue de la Louche", "8 Rue des Olivettes", Duration.ZERO,150.7, 5, LocalDateTime.now());
		this.annonceRepo.save(a1);
		Assertions.assertThat(annonceRepo.findAll().contains(a1));
	}
}


