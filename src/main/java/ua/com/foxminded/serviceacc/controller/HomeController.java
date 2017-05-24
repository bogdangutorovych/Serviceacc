package ua.com.foxminded.serviceacc.controller;

import javax.inject.Named;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by andreb on 08.04.17.
 */
@Named
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "templates/masterLayout.xhtml";
    }

}
