package dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.repository.AnnonceRepository;

@RestController
@CrossOrigin
@RequestMapping("annonces/")
public class AnnonceController {

	@Autowired
	private AnnonceRepository annonceRepo;

}
