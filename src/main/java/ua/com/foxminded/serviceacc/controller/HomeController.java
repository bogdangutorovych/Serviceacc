package ua.com.foxminded.serviceacc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by andreb on 08.04.17.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "template.xhtml";
    }

}
