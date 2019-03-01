package org.ivanov.Controllers;

import org.ivanov.Domain.entity.Brand;
import org.ivanov.Domain.entity.Car;
import org.ivanov.Domain.entity.Person;
import org.ivanov.Domain.repositories.BrandRepository;
import org.ivanov.Domain.repositories.CarRepository;

import org.ivanov.Domain.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarRepository carRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    BrandRepository brandRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return "car/index";
    }


    @GetMapping("/add")
    public String addCar(Model model) {
        model.addAttribute("persons", personRepository.findAll());
        model.addAttribute("brands", brandRepository.findAll());
        return "car/add";
    }


    @PostMapping("/add")
    public String addCar(@ModelAttribute Car car, BindingResult result,
                         @RequestParam Integer personId,
                         @RequestParam Integer brandId,
                         RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            for (ObjectError err : result.getAllErrors()) {
                System.out.println(err);
            }
            redirectAttributes.addFlashAttribute("car", "Binding error");
        } else {
            redirectAttributes.addFlashAttribute("car", "Added successfully");
            Person person = personRepository.findById(personId).get();
            car.setPerson(person);
            Brand brand = brandRepository.findById(brandId).get();
            //Request processing failed; nested exception is java.util.NoSuchElementException: No value present
            car.setBrand(brand);
            carRepository.save(car);
        }
        return "redirect:/car";
    }

    @GetMapping("/delete/{carId}")
    public String delete(@PathVariable Integer carId) {
        carRepository.deleteById(carId);
        return "redirect:/car";
    }


    @GetMapping("/edit/{carId}")
    public String edit(Model model, @PathVariable Integer carId) {
        model.addAttribute("car", carRepository.findById(carId).get());
        model.addAttribute("brands", brandRepository.findAll());
        model.addAttribute("persons", personRepository.findAll());
        return "car/edit";
    }

    @PostMapping("/edit/{carId}")
    public String edit(Model model, @ModelAttribute Car car, @PathVariable Integer carId,@RequestParam Integer brandId, @RequestParam Integer personId) {
    Brand brand = brandRepository.findById(brandId).get();
        car.setBrand(brand);
        Person person = personRepository.findById(personId).get();
        car.setPerson(person);
        carRepository.save(car);
        return "redirect:/car";
    }

}
