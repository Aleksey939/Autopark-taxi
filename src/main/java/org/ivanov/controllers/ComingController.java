package org.ivanov.controllers;

import lombok.var;
import org.ivanov.domains.entities.Car;
import org.ivanov.domains.entities.Coming;

import org.ivanov.domains.entities.Person;
import org.ivanov.domains.repositories.CarRepository;
import org.ivanov.domains.repositories.ComingRepository;
import org.ivanov.domains.repositories.PaymentRepository;
import org.ivanov.domains.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

//@EnableGlobalMethodSecurity(securedEnabled = true)
@Controller
@RequestMapping("/coming")
public class ComingController {


    @Autowired
    ComingRepository comingRepository;

    @Autowired
    CarRepository carRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    PaymentRepository paymentRepository;

    @GetMapping
    public String index(Model model, RedirectAttributes attr) {
//        List<Coming> comingsPost = null;
//        if (comingsPost != null)
//            Collections.sort(comingsPost, (a, b) -> a.getStartDate().isAfter(b.getStartDate()) ? -1 : a.getStartDate().isAfter(b.getStartDate()) ? 0 : 1);
//        model.addAttribute("comings", comingsPost);
        List<Person> persons = personRepository.findAll();
        List<Person> personinvestor=new ArrayList<>();
        for (Person person:persons) {
            if (person.getStatus().equals("ROLE_Investor"))
            personinvestor.add(person);
        }
        model.addAttribute("persons",personinvestor );
        model.addAttribute("cars", carRepository.findAll());


        return "coming/index2";
    }

    @PostMapping()
    public String index(Model model, @RequestParam Integer personId, @RequestParam Integer carId,
                        @RequestParam String date1, @RequestParam String date2, RedirectAttributes attr) {
        List<Coming> comingsPost;
        LocalDate datestart = LocalDate.parse(date1);
        LocalDate dateend = LocalDate.parse(date2);

        List<Coming> comings = comingRepository.findAll();
        comingsPost = new ArrayList<>();

        if (personId == 0 && carId == 0) {
//            comingsPost = comingRepository.findAll();
            for (Coming coming : comings) {
                if (coming.getStartDate().isAfter(datestart) && coming.getStartDate().isBefore(dateend))
                                        comingsPost.add(coming);
            }
            attr.addFlashAttribute("comings", comingsPost);
//            model.addAttribute("comings", comingsPost);
            return "redirect:/coming";


        } else if (personId != 0 && carId == 0) {
            for (Coming coming : comings) {
                if (coming.getCar().getPerson().getId() == personId && coming.getStartDate().isAfter(datestart) && coming.getStartDate().isBefore(dateend)) {


                    comingsPost.add(coming);

                }
            }
        } else if (personId == 0 && carId != 0) {
            for (Coming coming : comings) {
                if (coming.getCar().getId() == carId && coming.getStartDate().isAfter(datestart) && coming.getStartDate().isBefore(dateend)) {


                    comingsPost.add(coming);
                }
            }
        } else {
            for (Coming coming : comings) {
                if (coming.getCar().getPerson().getId() == personId && coming.getCar().getId() == carId && coming.getStartDate().isAfter(datestart) && coming.getStartDate().isBefore(dateend)) {


                    comingsPost.add(coming);
                }
            }

        }

        Collections.sort(comingsPost, (a, b) -> a.getStartDate().isAfter(b.getStartDate()) ? -1 : a.getStartDate().isAfter(b.getStartDate()) ? 0 : 1);

        attr.addFlashAttribute("comings", comingsPost);


        if (carId != 0) {
            Car carPost = carRepository.findById(carId).get();
            attr.addFlashAttribute("carPost", carPost);
        }


        if (personId != 0) {
            Person personPost = personRepository.findById(personId).get();
            attr.addFlashAttribute("personPost", personPost);
        }

        return "redirect:/coming";
    }

    @Secured("ROLE_Admin")
    @GetMapping("/add")
    public String addComing(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return "coming/add";
    }
    @Secured("ROLE_Admin")
    @PostMapping("/add")
    public String addComing(@ModelAttribute Coming coming, BindingResult result, @RequestParam Integer carId,
                            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            for (ObjectError err : result.getAllErrors()) {
                System.out.println(err);
            }
            redirectAttributes.addFlashAttribute("coming", "Binding error");
        } else {


            coming.setStartDate(LocalDate.parse(coming.getStartDateDto(),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd")));


            redirectAttributes.addFlashAttribute("coming", "Added successfully");
            Car car = carRepository.findById(carId).get();
            coming.setCar(car);


            coming.setFundMaintenance(Round2(coming.getMileage() * 0.13));
            coming.setFundRepairs(Round2(coming.getMileage() * 0.35));
            coming.setCommissionPartner(Round2(coming.getIncome() * 0.07 + coming.getBonus() * 0.07));
            coming.setDriverSalary(Round2(coming.getIncome() * 0.35));
            coming.setConsumptionOneKm(Round2(coming.getFuelCosts() / (double) coming.getMileage()));
            coming.setProfitOneKm(Round2(coming.getIncome() / (double) coming.getMileage()));
            var allCommingsbyCar = comingRepository.findAllByCar(car);

            if (allCommingsbyCar.size() == 0) {
                coming.setCapitalizationMaintenanceStart(0);
                coming.setCapitalizationRepairsStart(0);
            } else {
                coming.setCapitalizationMaintenanceStart(allCommingsbyCar.get(allCommingsbyCar.size() - 1).getCapitalizationMaintenanceEnd());
                coming.setCapitalizationRepairsStart(allCommingsbyCar.get(allCommingsbyCar.size() - 1).getCapitalizationRepairsEnd());
            }
            coming.setCapitalizationMaintenanceEnd(Round2(coming.getCapitalizationMaintenanceStart() + coming.getFundMaintenance() - coming.getCostsOfMaintenance()));
            coming.setCapitalizationRepairsEnd(Round2(coming.getCapitalizationRepairsStart() + coming.getFundRepairs() - coming.getCostsOfRepairs()));


            coming.setProfit(Round2(coming.getIncome()
                    + coming.getBonus()
                    - coming.getCommissionPartner()
                    - coming.getDriverSalary()
                    - coming.getFuelCosts()
                    - coming.getFundMaintenance()
                    - coming.getFundRepairs()
                    - coming.getCurrentExpenses()
                    - coming.getCarWash()));

            coming.setCommissionControl(Round2(coming.getProfit() * 0.25));
            coming.setInvestorIncome(Round2(coming.getProfit() - coming.getCommissionControl()));
            coming.setDepreciation((coming.getCar().getPriceStart() * 28 - coming.getCar().getPriceEnd() * 28) / 104);
            coming.setNetinvestorIncome(Round2(coming.getInvestorIncome() - coming.getDepreciation()));


            comingRepository.save(coming);
        }
        return "redirect:/coming";
    }
    @Secured("ROLE_Admin")
    @GetMapping("/delete/{comingId}")
    public String delete(@PathVariable Integer comingId) {

        comingRepository.deleteById(comingId);

        return "redirect:/coming";
    }

    @Secured("ROLE_Admin")
    @GetMapping("/edit/{comingId}")
    public String edit(Model model, @PathVariable Integer comingId) {
        model.addAttribute("coming", comingRepository.findById(comingId).get());
        model.addAttribute("cars", carRepository.findAll());

        return "coming/edit";
    }
    @Secured("ROLE_Admin")
    @PostMapping("/edit/{comingId}")
    public String edit(Model model, @ModelAttribute Coming coming, @PathVariable Integer comingId, @RequestParam Integer carId) {

        Car car = carRepository.findById(carId).get();
        //List<Coming> allCommingsbyCar = comingRepository.findAllByCar(car);
        coming.setStartDate(LocalDate.parse(coming.getStartDateDto(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        coming.setCar(car);

        coming.setFundMaintenance(Round2(coming.getMileage() * 0.13));
        coming.setFundRepairs(Round2(coming.getMileage() * 0.35));
        coming.setCommissionPartner(Round2(coming.getIncome() * 0.07 + coming.getBonus() * 0.07));
        coming.setDriverSalary(Round2(coming.getIncome() * 0.35));
        coming.setConsumptionOneKm(Round2(coming.getFuelCosts() / (double) coming.getMileage()));
        coming.setProfitOneKm(Round2(coming.getIncome() / (double) coming.getMileage()));
        //coming.setCapitalizationMaintenanceStart(allCommingsbyCar.get(allCommingsbyCar.size() - 1).getCapitalizationMaintenanceEnd());
        coming.setCapitalizationMaintenanceEnd(Round2(coming.getCapitalizationMaintenanceStart() + coming.getFundMaintenance() - coming.getCostsOfMaintenance()));
        //coming.setCapitalizationRepairsStart(allCommingsbyCar.get(allCommingsbyCar.size() - 1).getCapitalizationRepairsEnd());
        coming.setCapitalizationRepairsEnd(Round2(coming.getCapitalizationRepairsStart() + coming.getFundRepairs() - coming.getCostsOfRepairs()));


        coming.setProfit(Round2(coming.getIncome()
                + coming.getBonus()
                - coming.getCommissionPartner()
                - coming.getDriverSalary()
                - coming.getFuelCosts()
                - coming.getFundMaintenance()
                - coming.getFundRepairs()
                - coming.getCurrentExpenses()
                - coming.getCarWash()));

        coming.setCommissionControl(Round2(coming.getProfit() * 0.25));
        coming.setInvestorIncome(Round2(coming.getProfit() - coming.getCommissionControl()));
        coming.setDepreciation((coming.getCar().getPriceStart() * 28 - coming.getCar().getPriceEnd() * 28) / 104);
        coming.setNetinvestorIncome(Round2(coming.getInvestorIncome() - coming.getDepreciation()));
        comingRepository.save(coming);
        return "redirect:/coming";
    }

    public static double Round2(double value) {
        int iValue = (int) (value * 100);
        double dValue = value * 100;
        if (dValue - iValue >= 0.5) {
            iValue += 1;
        }
        dValue = (double) iValue;
        return dValue / 100;
    }
}
