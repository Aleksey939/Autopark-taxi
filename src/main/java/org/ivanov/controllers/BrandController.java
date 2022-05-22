package org.ivanov.controllers;

import org.ivanov.domain.entity.Brand;
import org.ivanov.domain.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    BrandRepository brandRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("brands", brandRepository.findAll());
        return "brand/index";
    }

    @GetMapping("/add")
    public String addCar(Model model) {
        model.addAttribute("brands", brandRepository.findAll());

        return "brand/add";
    }

    @PostMapping("/add")
    public String addCar(@ModelAttribute Brand brand, BindingResult result,

                         RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            for (ObjectError err : result.getAllErrors()) {
                System.out.println(err);
            }
            redirectAttributes.addFlashAttribute("brand", "Binding error");
        } else {
            redirectAttributes.addFlashAttribute("brand", "Added successfully");


            brandRepository.save(brand);
        }
        return "redirect:/brand";
    }

    @GetMapping("/edit/{brandId}")
    public String editBrand(@PathVariable Integer brandId, Model model) {
        model.addAttribute("brand", brandRepository.findById(brandId));

        return "brand/edit";
    }

    @PostMapping("/edit/{brandId}")
    public String editBrand(Model model, @ModelAttribute Brand brand, @PathVariable Integer brandId) {

        brandRepository.save(brand);

        return "redirect:/brand";
    }
}
