package ua.com.foxminded.serviceacc.controller.deal;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.Deal;
import ua.com.foxminded.serviceacc.service.DealService;

@Named
@ViewScoped
public class DealListController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(DealListController.class);

    private static final long serialVersionUID = 1L;
    private List<Deal> clientDeals;
    private DealService dealService;

    @Inject
    public DealListController(DealService dealService) {
        this.dealService = dealService;
    }

    public void delete(Deal deal) {
        dealService.delete(deal.getId());
    }

    public DealService getDealService() {
        return dealService;
    }

    public void setDealService(DealService dealService) {
        this.dealService = dealService;
    }

    public void prepareClientDeals(Client client) {
        clientDeals = dealService.findByClient(client);
    }

    public void removeDealFromClient(Deal deal) {
        dealService.delete(deal.getId());
        clientDeals.remove(deal);
    }

    public List<Deal> getClientDeals() {
        return clientDeals;
    }

    public void setClientDeals(List<Deal> clientDeals) {
        this.clientDeals = clientDeals;
    }

}
