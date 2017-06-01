package ua.com.foxminded.serviceacc.controller.payment;

import java.io.Serializable;
import java.util.List;

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

    private Payment selected;
    private PaymentService paymentService;

    private List<Payment> payments;

    @Inject
    public PaymentListController(PaymentService paymentService) {
        this.paymentService = paymentService;
        log.debug("New PaymentListController");
    }

    public void prepareData(){
        log.debug("Prepare List Payments");
        this.payments = paymentService.findAll();
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public void add() {
        selected = new Payment();
    }

    public void onOk() {
        selected = paymentService.save(selected);
    }

    public void clearSelected() {
        selected = null;
    }

    public void onCancel() {
        selected = null;
    }

    public Payment getSelected() {
        return selected;
    }

    public void setSelected(Payment selected) {
        this.selected = selected;
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

}
