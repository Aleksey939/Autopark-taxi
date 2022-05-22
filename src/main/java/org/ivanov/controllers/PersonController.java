package org.ivanov.controllers;

import org.ivanov.domain.entity.Authorities;
import org.ivanov.domain.entity.Person;
import org.ivanov.domain.repositories.AuthoritiesRepository;
import org.ivanov.domain.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    AuthoritiesRepository authoritiesRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("persons", personRepository.findAll());
        return "person/index";
    }

    @GetMapping("/add")
    public String addPerson(Model model) {
        model.addAttribute("persons", personRepository.findAll());
        return "person/add";
    }

    @PostMapping("/add")
    public String addPerson(@ModelAttribute Person person, BindingResult result,
                              RedirectAttributes redirectAttributes ){


        if (result.hasErrors()) {
            for (ObjectError err : result.getAllErrors()) {
                System.out.println(err);
            }
            redirectAttributes.addFlashAttribute("person", "Binding error");
        } else {
            redirectAttributes.addFlashAttribute("person", "Added successfully");

//            String md5Hex = DigestUtils.md5Hex(person.getPassword());
//            person.setPassword(md5Hex);
            person.setPassword("{noop}"+person.getPassword());
            personRepository.save(person);
              Authorities authorities= new Authorities(person.getEmail(),person.getStatus(),person);
              authoritiesRepository.save(authorities);

        }
        return "redirect:/person";
    }

    @GetMapping("/delete/{personId}")
    public String delete (@PathVariable Integer personId) {
        personRepository.deleteById(personId);
          return "redirect:/person";
    }


    @GetMapping("/edit/{personId}")
    public String edit (Model model,@PathVariable Integer personId) {

        model.addAttribute("person", personRepository.findById(personId).get());
        return "person/edit";
    }

    @PostMapping("/edit/{personId}")
    public String edit (@ModelAttribute Person person, @PathVariable Integer personId) {
//        String md5Hex = DigestUtils.md5Hex(person.getPassword());
//        person.setPassword(md5Hex);
        person.setPassword("{noop}"+person.getPassword());
        personRepository.save(person);
        Authorities authorities= new Authorities(person.getEmail(),person.getStatus(),person);
        authoritiesRepository.save(authorities);
        return "redirect:/person";
    }

}
