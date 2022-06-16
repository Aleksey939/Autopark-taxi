package org.ivanov.controllers;

import org.ivanov.domains.entities.Car;
import org.ivanov.domains.entities.WorkDone;
import org.ivanov.domains.repositories.CarRepository;
import org.ivanov.domains.repositories.WorkDoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/workdone")
public class WorkDoneController {

    List<WorkDone> workDonesPost;
    @Autowired
    WorkDoneRepository workDoneRepository;
    @Autowired
    CarRepository carRepository;
    @GetMapping
    public String index(Model model) {
        model.addAttribute("workdones", workDonesPost);
        model.addAttribute("cars", carRepository.findAll());
        return "workdone/index";
    }
    @PostMapping()
    public String index(Model model, @RequestParam Integer carId) {

        if (carId == 0) {
            workDonesPost=workDoneRepository.findAll();
            model.addAttribute("workdones",workDonesPost);
            return "redirect:/workdone";
        }
        else  {
            List<WorkDone> workDones = workDoneRepository.findAll();
            workDonesPost = new ArrayList<>();
            for (WorkDone workDone : workDones) {
                if (workDone.getCar().getId() == carId) {
                    workDonesPost.add(workDone);
                }
            }
            model.addAttribute("workdones", workDonesPost);
        }

        return "redirect:/workdone";
    }
    @GetMapping("/add")
    public String addPayment(Model model) {
        model.addAttribute("workdones", workDoneRepository.findAll());
        model.addAttribute("cars", carRepository.findAll());
        return "workdone/add";
    }

    @PostMapping("/add")
    public String addPayment(@ModelAttribute WorkDone workDone, BindingResult result,
                             @RequestParam Integer carId, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            for (ObjectError err : result.getAllErrors()) {
                System.out.println(err);
            }
            redirectAttributes.addFlashAttribute("workDone", "Binding error");
        } else {
            redirectAttributes.addFlashAttribute("workDone", "Added successfully");

            Car car = carRepository.findById(carId).get();
            workDone.setCar(car);
            workDoneRepository.save(workDone);
        }
        return "redirect:/workdone";
    }
    @GetMapping("/delete/{workdoneId}")
    public String delete(@PathVariable Integer workdoneId) {
        workDoneRepository.deleteById(workdoneId);
        return "redirect:/workdone";
    }
    @GetMapping("/edit/{workdoneId}")
    public String edit(@PathVariable Integer workdoneId, Model model) {
        model.addAttribute("workDone", workDoneRepository.findById(workdoneId));
        model.addAttribute("cars", carRepository.findAll());

        return "workdone/edit";
    }
    @PostMapping("/edit/{workdoneId}")
    public String edit(Model model, @ModelAttribute WorkDone workDone, @PathVariable Integer workdoneId, @RequestParam Integer carId ) {

        Car car = carRepository.findById(carId).get();
        workDone.setCar(car);
        workDoneRepository.save(workDone);

        return "redirect:/workdone";
    }
}
