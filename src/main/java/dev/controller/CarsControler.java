package dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.entity.Car;
import dev.repository.CarsRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("./admin/vehicules")
public class CarsControler {

	@Autowired
	CarsRepository carsControler;

	@RequestMapping(method = RequestMethod.GET)
	public List<Car> getListCars(Model model) {
		return carsControler.findAll();
	}

	// @RequestMapping(method = RequestMethod.GET)
	// public String getListCarsWithFilter(Model model, @RequestParam("immat")
	// String immat, @RequestParam("brand") String brand) {
	// List<Car> cars = new ArrayList<Car>();
	//
	// if (!brand.equals("") && immat.equals("")) {
	// model.addAttribute("CarsList",
	// carsControler.findAllByBrandIsStartingWith(brand));
	// } else if (brand.equals("") && !immat.equals("")) {
	// model.addAttribute("CarsList",
	// carsControler.findAllByImmatriculationStartingWith(immat));
	// } else {
	// model.addAttribute("CarsList",
	// carsControler.findAllByBrandIsStartingWithAndImmatriculationStartingWith(brand,
	// immat));
	// }
	// model.addAttribute("category", Car.CarCategory.values());
	//
	// return "./admin/vehicules";
	// }

	@RequestMapping(method = RequestMethod.POST)
	public String submitFormCar(@ModelAttribute("formCar") Car car) {
		carsControler.save(car);
		return "redirect:./admin/vehicules";
	}
}
