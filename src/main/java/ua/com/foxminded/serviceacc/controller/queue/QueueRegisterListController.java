package ua.com.foxminded.serviceacc.controller.queue;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.QueueRegister;
import ua.com.foxminded.serviceacc.service.QueueRegisterService;

@Named
@RequestScoped
public class QueueRegisterListController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(QueueRegisterListController.class);

    private static final long serialVersionUID = 1L;

    private List<QueueRegister> list;

    private final QueueRegisterService queueRegisterService;

    @Inject
    public QueueRegisterListController(QueueRegisterService queueRegisterService) {
        this.queueRegisterService = queueRegisterService;
    }

    @PostConstruct
    public void init(){
        prepareData();
    }

    public void prepareData(){
        list = queueRegisterService.findAll();
    }

    public List<QueueRegister> getList() {
        return list;
    }

    public void setList(List<QueueRegister> list) {
        this.list = list;
    }

}
