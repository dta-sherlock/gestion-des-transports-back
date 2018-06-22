package dev.controller;

import java.util.List;

import dev.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import dev.entity.Vehicules;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin/vehicules")
public class CarsControler {

	@Autowired
	CarRepository carsControler;

	@RequestMapping(method = RequestMethod.GET)
	public List<Vehicules> getListCars(Model model) {
		return carsControler.findAll();
	}


	@RequestMapping(method = RequestMethod.POST,path = "/creer")
	public String submitFormCar(@RequestBody Vehicules car) {
		carsControler.save(car);
		return "redirect:/admin/vehicules";
	}
}
