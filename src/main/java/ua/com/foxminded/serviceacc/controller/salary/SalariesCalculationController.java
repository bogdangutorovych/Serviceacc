package ua.com.foxminded.serviceacc.controller.salary;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ViewScoped
@ManagedBean
public class SalariesCalculationController {
    private static final Logger log = LoggerFactory.getLogger(SalariesCalculationController.class);

    public void calculateSalaries() {
        log.info("calculateSalaries");
    }
}
