package org.ivanov.controllers;

import org.ivanov.domains.entities.*;
import org.ivanov.domains.repositories.CarRepository;
import org.ivanov.domains.repositories.ComingRepository;
import org.ivanov.domains.repositories.PaymentRepository;
import org.ivanov.domains.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/payment")
//@Secured("ROLE_Admin")
public class PaymentController {

    @Autowired
    ComingRepository comingRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    PersonRepository personRepository;
    @Autowired
    PaymentRepository paymentRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("comings", comingRepository.findAll());
        model.addAttribute("persons", personRepository.findAll());
        model.addAttribute("cars", carRepository.findAll());
        //model.addAttribute("payments", paymentPost);
        return "payment/index";
    }
    @PostMapping()
    public String index(Model model, @RequestParam Integer personId, RedirectAttributes attr) {
        List<Payment> paymentPost;
        if (personId == 0) {

            paymentPost=paymentRepository.findAll();
//            for(Coming coming : comingRepository.findAll())
//                if (coming.getPaid==true)
//                    paymentPost.add(coming);
//            model.addAttribute("payments",paymentPost);
            attr.addFlashAttribute("payments",paymentPost );
            return "redirect:/payment";
        }
        else  {
//            List<Payment> payments = paymentRepository.findAll();
//            paymentPost = new ArrayList<>();
//            for (Payment payment : payments) {
//                if (payment.getPerson().getId() == personId) {
//                    paymentPost.add(payment);
//                }
//            }
//            attr.addFlashAttribute("payments",paymentPost );
//            model.addAttribute("payments", paymentPost);
        }

        return "redirect:/payment";
    }


    @GetMapping("/addpaymentforComing/{comingId}")
    public String addPayment(Model model,@PathVariable Integer comingId) {
        Coming coming= comingRepository.findById(comingId).get();
        model.addAttribute("coming", coming);
        model.addAttribute("person", coming.getCar().getPerson());
        model.addAttribute("payments", paymentRepository.findAll());
        return "payment/add";
    }


    @PostMapping("/addpaymentforComing/{comingId}")
    public String addPayment(@ModelAttribute Payment payment, BindingResult result, @PathVariable Integer comingId,
                          RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            for (ObjectError err : result.getAllErrors()) {
                System.out.println(err);
            }
            redirectAttributes.addFlashAttribute("payment", "Binding error");
        } else {
            redirectAttributes.addFlashAttribute("payment", "Added successfully");
            //Person person = personRepository.findById(personId).get();
            Coming coming = comingRepository.findById(comingId).get();
//            payment.setStartDate(LocalDate.parse(payment.getStartDateDto(),
//                    DateTimeFormatter.ofPattern("yyyy-MM-dd")));

//            payment.setPerson(coming.getCar().getPerson());
//            payment.setStartDate(coming.getStartDate().toString());
//            payment.setSum(coming.getInvestorIncome());
           // Date parsedDate = new SimpleDateFormat("dd.MM.yyyy HH:mm").parse(value);
           // payment.setTime(new Timestamp(timestamp.getTime()));//вылетает Request processing failed; nested exception is java.lang.NullPointerException
            coming.setPayment(true);
            comingRepository.save(coming);

//            payment.setComing(coming);

//            paymentRepository.save(payment);
        }
        return "redirect:/coming";
    }

    @GetMapping("/delete/{comingId}")
    public String delete(@PathVariable Integer comingId) {
        Coming coming = comingRepository.findById(comingId).get();
        coming.setPayment(false);
        comingRepository.save(coming);
//        Payment payment=paymentRepository.findById(paymentId).get();

//        if(payment.getComing()!=null) {
//            Coming coming = comingRepository.findById(payment.getComing().getId()).get();
//
//                coming.setPaid(false);
//                comingRepository.save(coming);
//
//        }
//        paymentRepository.deleteById(paymentId);
        return "redirect:/coming";
    }
}



//    HashMap<String, String> params = new HashMap<String, String>();
//params.put("action", "pay");
//        params.put("amount", "1");
//        params.put("currency", "USD");
//        params.put("description", "description text");
//        params.put("order_id", "order_id_1");
//        params.put("version", "3");
//        LiqPay liqpay = new LiqPay(PUBLIC_KEY, PRIVATE_KEY);
//        String html = liqpay.cnb_form(params);
//        System.out.println(html);