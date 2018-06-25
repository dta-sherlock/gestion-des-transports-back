package dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entity.Annonce;
import dev.repository.AnnonceRepository;

@RestController
@CrossOrigin
@RequestMapping("annonces/")
public class AnnonceController {

	@Autowired
	private AnnonceRepository annonceRepo;

	@GetMapping
	public List<Annonce> findAllAnnonce() {
		return this.annonceRepo.findAll();

	}

	@PostMapping(path = "/creer")
	public void submitAnnonce(@RequestBody Annonce annonce) {
		this.annonceRepo.save(annonce);
	}
}
