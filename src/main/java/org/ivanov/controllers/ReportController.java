package org.ivanov.controllers;

import org.ivanov.domains.repositories.CarRepository;
import org.ivanov.domains.repositories.ComingRepository;
import org.ivanov.domains.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    ComingRepository comingRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    PersonRepository personRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("comings", comingRepository.findAll());
        model.addAttribute("persons", personRepository.findAll());
        model.addAttribute("cars", carRepository.findAll());
        return "report/index";
    }
}
