package ua.com.foxminded.serviceacc.controller.deal;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Deal;
import ua.com.foxminded.serviceacc.service.DealService;

@Named
@RequestScoped
@ManagedBean
public class DealListController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(DealListController.class);

    private static final long serialVersionUID = 1L;

    private List<Deal> list;

    private DealService dealService;

    public DealListController(DealService dealService) {
        this.dealService = dealService;
    }

    @PostConstruct
    public void init() {
        list = dealService.findAll();
    }

    public void delete(Deal deal) {
        dealService.delete(deal.getId());
        list.remove(deal);
    }

    public List<Deal> getList() {
        return list;
    }

    public void setList(List<Deal> list) {
        this.list = list;
    }

    public DealService getDealService() {
        return dealService;
    }

    public void setDealService(DealService dealService) {
        this.dealService = dealService;
    }

}
