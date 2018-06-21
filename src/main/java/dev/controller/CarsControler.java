package dev.controller;

import java.util.List;

import dev.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.entity.Car;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("admin/vehicules")
public class CarsControler {

	@Autowired
	CarRepository carsControler;

	@RequestMapping(method = RequestMethod.GET)
	public List<Car> getListCars(Model model) {
		return carsControler.findAll();
	}


	@RequestMapping(method = RequestMethod.POST)
	public String submitFormCar(@ModelAttribute("creationForm") Car car) {
		carsControler.save(car);
		return "redirect:admin/vehicules";
	}
}
