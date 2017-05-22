package ua.com.foxminded.serviceacc.controller.deal;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.Deal;
import ua.com.foxminded.serviceacc.model.Service;
import ua.com.foxminded.serviceacc.service.DealService;

@Named
@ViewScoped
@ManagedBean
public class DealController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(DealController.class);

    private static final long serialVersionUID = 1L;

    private Deal selected;
    private DealService dealService;

    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    public void add(Client client) {
        selected = new Deal();
        selected.setClient(client);
        selected.setService(new Service());
    }

    public void onOk() {
        if (selected.getId() == null) {
            selected = dealService.save(selected);
        }
        dealService.save(selected);
    }

    public void clearSelected() {
        selected = null;
    }

    public void onCancel() {
        selected = null;
    }

    public Deal getSelected() {
        return selected;
    }

    public void setSelected(Deal selected) {
        this.selected = selected;
    }

    public DealService getDealService() {
        return dealService;
    }

    public void setDealService(DealService dealService) {
        this.dealService = dealService;
    }

}
