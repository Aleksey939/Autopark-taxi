package org.ivanov.controllers;

import lombok.RequiredArgsConstructor;
import org.ivanov.domain.entity.Car;
import org.ivanov.domain.entity.WorkDone;
import org.ivanov.domain.repositories.CarRepository;
import org.ivanov.service.WorkDoneService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/workdone")
@RequiredArgsConstructor
public class WorkDoneController {
    private static final String WORKDONE = "workDone";
    private static final String WORKDONES = "workdones";
    
    final WorkDoneService workDoneService;
    final CarRepository carRepository;

    List<WorkDone> workDonesPost;

    @GetMapping
    public String index(Model model) {
        model.addAttribute(WORKDONES, workDonesPost);
        model.addAttribute("cars", carRepository.findAll());
        return "workdone/index";
    }
    @PostMapping()
    public String index(Model model, @RequestParam Integer carId) {
        if (carId == 0) {
            workDonesPost = workDoneService.findAll();
        }
        else {
            workDonesPost = workDoneService.findAllByCarId(carId);
        }
        model.addAttribute(WORKDONES, workDonesPost);

        return "redirect:/workdone";
    }
    @GetMapping("/add")
    public String addPayment(Model model) {
        model.addAttribute(WORKDONES, workDoneService.findAll());
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
            redirectAttributes.addFlashAttribute(WORKDONE, "Binding error");
        } else {
            redirectAttributes.addFlashAttribute(WORKDONE, "Added successfully");

            Car car = carRepository.findById(carId).get();
            workDone.setCar(car);
            workDoneService.save(workDone);
        }
        return "redirect:/workdone";
    }
    @GetMapping("/delete/{workdoneId}")
    public String delete(@PathVariable Integer workdoneId) {
        workDoneService.deleteById(workdoneId);
        return "redirect:/workdone";
    }
    @GetMapping("/edit/{workdoneId}")
    public String edit(@PathVariable Integer workdoneId, Model model) {
        model.addAttribute(WORKDONE, workDoneService.findById(workdoneId));
        model.addAttribute("cars", carRepository.findAll());

        return "workdone/edit";
    }
    @PostMapping("/edit/{workdoneId}")
    public String edit(Model model, @ModelAttribute WorkDone workDone, @PathVariable Integer workdoneId, @RequestParam Integer carId ) {
        Car car = carRepository.findById(carId).get();
        workDone.setCar(car);
        workDoneService.save(workDone);

        return "redirect:/workdone";
    }
}
