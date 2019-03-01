package org.ivanov.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public String indexget(Model model) {
//        String errorMessge = null;
//        if(error != null) {
//            errorMessge = "Username or Password is incorrect !!";
//        }
//        if(logout != null) {
//            errorMessge = "You have been successfully logged out !!";
//        }
//        model.addAttribute("errorMessge", errorMessge);
//        (@RequestParam(value = "error", required = false) String error,
//                @RequestParam(value = "logout", required = false) String logout,
        return "home/login";
    }

        @PostMapping
        public String index(Model model
              ) {
//        String errorMessge = null;
//        if(error != null) {
//            errorMessge = "Username or Password is incorrect !!";
//        }
//        if(logout != null) {
//            errorMessge = "You have been successfully logged out !!";
//        }
//        model.addAttribute("errorMessge", errorMessge);
//        (@RequestParam(value = "error", required = false) String error,
//                @RequestParam(value = "logout", required = false) String logout,
            return "home/index";
    }
}
