package ua.com.foxminded.serviceacc.controller.queue;

import java.io.Serializable;
import java.time.LocalDate;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Deal;
import ua.com.foxminded.serviceacc.model.QueueRegister;
import ua.com.foxminded.serviceacc.service.QueueRegisterService;

@Named
@ViewScoped
public class QueueRegisterController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(QueueRegisterController.class);

    private static final long serialVersionUID = 1L;

    private QueueRegister selected;
    private QueueRegisterService queueRegisterService;

    @Inject
    public QueueRegisterController(QueueRegisterService queueRegisterService) {
        this.queueRegisterService = queueRegisterService;
    }

    public void add(Deal deal) {
        selected = new QueueRegister();
        selected.setDeal(deal);
        selected.setRegisterDate(LocalDate.now());
        queueRegisterService.save(selected);
    }

    public void onOk() {
        selected = queueRegisterService.save(selected);
    }

    public void delete() {
        queueRegisterService.delete(selected.getId());
        selected = null;
    }

    public void onCancel() {
        selected = null;
    }

    public QueueRegister getSelected() {
        return selected;
    }

    public void setSelected(QueueRegister selected) {
        this.selected = selected;
    }

    public QueueRegisterService getQueueRegisterService() {
        return queueRegisterService;
    }

    public void setQueueRegisterService(QueueRegisterService queueRegisterService) {
        this.queueRegisterService = queueRegisterService;
    }

}
