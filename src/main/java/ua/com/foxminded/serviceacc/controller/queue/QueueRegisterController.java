package ua.com.foxminded.serviceacc.controller.queue;

import java.io.Serializable;
import java.time.LocalDate;

import javax.faces.view.ViewScoped;
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

    private QueueRegister selectedQueue;
    private final QueueRegisterService queueRegisterService;

    @Inject
    public QueueRegisterController(QueueRegisterService queueRegisterService) {
        this.queueRegisterService = queueRegisterService;
    }

    public void add(Deal deal) {
        selectedQueue = new QueueRegister();
        selectedQueue.setDeal(deal);
        selectedQueue.setRegisterDate(LocalDate.now());
        queueRegisterService.save(selectedQueue);
    }

    public void onOk() {
        selectedQueue = queueRegisterService.save(selectedQueue);
    }

    public void delete() {
        queueRegisterService.delete(selectedQueue.getId());
        selectedQueue = null;
    }

    public void onCancel() {
        selectedQueue = null;
    }

    public QueueRegister getSelectedQueue() {
        return selectedQueue;
    }

    public void setSelectedQueue(QueueRegister selectedQueue) {
        this.selectedQueue = selectedQueue;
    }

}
