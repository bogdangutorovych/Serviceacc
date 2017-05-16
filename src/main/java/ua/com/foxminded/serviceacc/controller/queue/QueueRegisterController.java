package ua.com.foxminded.serviceacc.controller.queue;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.QueueRegister;
import ua.com.foxminded.serviceacc.model.Service;
import ua.com.foxminded.serviceacc.service.ClientService;
import ua.com.foxminded.serviceacc.service.QueueEnrollService;
import ua.com.foxminded.serviceacc.service.ServiceService;

@Controller
@ViewScoped
@ManagedBean
public class QueueRegisterController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(QueueRegisterController.class);

    private static final long serialVersionUID = 1L;

    private QueueRegister selected;
    private List<QueueRegister> list;

    private List<Client> availableClients;
    private List<Service> availableServices;

    private QueueEnrollService queueEnrollService;
    private ClientService clientService;
    private ServiceService serviceService;

    public QueueRegisterController(QueueEnrollService queueEnrollService, ClientService clientService,
            ServiceService serviceService) {
        this.queueEnrollService = queueEnrollService;
        this.clientService = clientService;
        this.serviceService = serviceService;
    }

    @PostConstruct
    public void init() {
        list = queueEnrollService.findAll();
    }

    public void add() {
        selected = new QueueRegister();
        getActualLists();
    }

    public void getActualLists() {
        availableClients = clientService.findAll();
        availableServices = serviceService.findAll();
    }

    public void onOk() {
        if (selected.getId() == null) {
            selected = queueEnrollService.create(selected);
        }

        queueEnrollService.update(selected);
        init();

    }

    public void delete() {
        list.remove(selected);
        queueEnrollService.delete(selected.getId());
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

    public List<QueueRegister> getList() {
        return list;
    }

    public void setList(List<QueueRegister> list) {
        this.list = list;
    }

    public List<Client> getAvailableClients() {
        return availableClients;
    }

    public void setAvailableClients(List<Client> availableClients) {
        this.availableClients = availableClients;
    }

    public List<Service> getAvailableServices() {
        return availableServices;
    }

    public void setAvailableServices(List<Service> availableServices) {
        this.availableServices = availableServices;
    }

    public QueueEnrollService getQueueEnrollService() {
        return queueEnrollService;
    }

    public void setQueueEnrollService(QueueEnrollService queueEnrollService) {
        this.queueEnrollService = queueEnrollService;
    }

    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public ServiceService getServiceService() {
        return serviceService;
    }

    public void setServiceService(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

}
