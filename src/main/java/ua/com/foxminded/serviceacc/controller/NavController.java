package ua.com.foxminded.serviceacc.controller;

import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Grischenko Maxim on 11.04.17.
 */
@ManagedBean
@SessionScoped
@Getter
@Setter
public class NavController {

    private String mainContent = "/client/content.xhtml";

}
