package ua.com.foxminded.serviceacc.controller.payment;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Payment;
import ua.com.foxminded.serviceacc.service.PaymentService;

@Named
@ViewScoped
public class PaymentListController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(PaymentListController.class);

    private static final long serialVersionUID = 1L;

    private final PaymentService paymentService;

    private List<Payment> payments;

    @Inject
    public PaymentListController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostConstruct
    public void init(){
        prepareData();
        log.debug("initiated PaymentListController");
    }

    public void prepareData(){
        this.payments = paymentService.findAll();
        log.debug("Prepared List Payments");
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

}
