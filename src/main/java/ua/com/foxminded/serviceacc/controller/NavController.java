package ua.com.foxminded.serviceacc.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/** Created by Grischenko Maxim on 11.04.17. */
@ManagedBean
@SessionScoped
public class NavController {

    private String mainContent = "/templates/client/clientList.xhtml";
    public String footer = "/templates/footer.xhtml";
    public String header = "/templates/header.xhtml";
    public String menu = "/templates/menu.xhtml";

    public String getMainContent() {
        return mainContent;
    }

    public void setMainContent(String mainContent) {
        this.mainContent = "/templates/" + mainContent + ".xhtml";
    }

    public String getFooter() {
        return footer;
    }

    public String getHeader() {
        return header;
    }

    public String getMenu() {
        return menu;
    }

}
