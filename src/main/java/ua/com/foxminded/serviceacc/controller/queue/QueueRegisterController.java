package ua.com.foxminded.serviceacc.controller.queue;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.Deal;
import ua.com.foxminded.serviceacc.model.QueueRegister;
import ua.com.foxminded.serviceacc.model.Service;
import ua.com.foxminded.serviceacc.service.ClientService;
import ua.com.foxminded.serviceacc.service.QueueRegisterService;
import ua.com.foxminded.serviceacc.service.ServiceService;

@Named
@ViewScoped
@ManagedBean
public class QueueRegisterController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(QueueRegisterController.class);

    private static final long serialVersionUID = 1L;

    private QueueRegister selected;
    private List<QueueRegister> list;

    private List<Client> availableClients;
    private List<Service> availableServices;

    private QueueRegisterService queueRegisterService;
    private ClientService clientService;
    private ServiceService serviceService;

    public QueueRegisterController(QueueRegisterService queueRegisterService, ClientService clientService,
            ServiceService serviceService) {
        this.queueRegisterService = queueRegisterService;
        this.clientService = clientService;
        this.serviceService = serviceService;
    }

    @PostConstruct
    public void init() {
        list = queueRegisterService.findAll();
    }

    public void add() {
        selected = new QueueRegister();
        getActualLists();
        selected.setDeal(new Deal());
    }

    public void getActualLists() {
        availableClients = clientService.findAll();
        availableServices = serviceService.findAll();
    }

    public void onOk() {
        selected = queueRegisterService.save(selected);
        init();
    }

    public void delete() {
        list.remove(selected);
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

    public QueueRegisterService getQueueRegisterService() {
        return queueRegisterService;
    }

    public void setQueueRegisterService(QueueRegisterService queueRegisterService) {
        this.queueRegisterService = queueRegisterService;
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
