package ua.com.foxminded.serviceacc.controller.contract;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Contract;
import ua.com.foxminded.serviceacc.service.ContractService;

@Named
@ViewScoped
@ManagedBean
public class ContractListController implements Serializable {

    private static Logger logger = LoggerFactory.getLogger(ContractListController.class);
    private static final long serialVersionUID = 1L;

    private List<Contract> list;
    private ContractService contractService;

    @Inject
    public ContractListController(ContractService contractService) {
        this.contractService = contractService;
    }

    @PostConstruct
    public void init() {
        list = contractService.findAll();
    }

    public List<Contract> getList() {
        return list;
    }

    public ContractService getContractService() {
        return contractService;
    }

    public void setContractService(ContractService contractService) {
        this.contractService = contractService;
    }

}
