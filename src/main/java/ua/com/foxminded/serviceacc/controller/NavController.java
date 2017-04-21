package ua.com.foxminded.serviceacc.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/** Created by Grischenko Maxim on 11.04.17. */
@ManagedBean
@SessionScoped
public class NavController {

    private String mainContent = "/client/clientList.xhtml";

    public String getMainContent() {
        return mainContent;
    }

    public void setMainContent(String mainContent) {
        this.mainContent = mainContent;
    }

    
}
