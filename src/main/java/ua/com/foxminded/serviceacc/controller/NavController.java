package ua.com.foxminded.serviceacc.controller;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/** Created by Grischenko Maxim on 11.04.17. */
@Named
@SessionScoped
public class NavController {

    private String mainContent = "/templates/client/clientList.xhtml";

    public String getMainContent() {
        return mainContent;
    }

    public void setMainContent(String mainContent) {
        this.mainContent = "/templates/" + mainContent + ".xhtml";
    }

}
