package ua.com.foxminded.serviceacc.controller.payment;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Payment;
import ua.com.foxminded.serviceacc.service.PaymentService;

@Named
@ViewScoped
public class PaymentController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    private static final long serialVersionUID = 1L;

    private Payment selected;
    private PaymentService paymentService;

    @Inject
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
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
