package org.ivanov.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/setting")
public class SettingController {


    @GetMapping
    public String index(Model model) {
        return "setting/index";
    }
}
