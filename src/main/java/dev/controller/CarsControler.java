package dev.controller;

import java.util.List;

import dev.entity.CompanyCar;
import dev.repository.CompanyCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import dev.entity.Car;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin/vehicules/")
public class CarsControler {

	@Autowired
	CompanyCarRepository carsControler;

	@RequestMapping(method = RequestMethod.GET)
	public List<CompanyCar> getListCars(Model model) {
		return carsControler.findAll();
	}


	@RequestMapping(method = RequestMethod.POST,path = "creer/")
	public String submitFormCar(@RequestBody CompanyCar car) {
		carsControler.save(car);
		return "redirect:/admin/vehicules";
	}
}
