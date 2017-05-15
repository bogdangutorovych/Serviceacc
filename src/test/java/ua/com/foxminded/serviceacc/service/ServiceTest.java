package ua.com.foxminded.serviceacc.service;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static ua.com.foxminded.serviceacc.ModelTestBuilder.buildTestService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import ua.com.foxminded.serviceacc.model.Money;
import ua.com.foxminded.serviceacc.model.Service;
import ua.com.foxminded.serviceacc.model.enums.Currency;

/**
 * Created by andreb on 05.05.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ServiceTest {

    @Autowired
    ServiceService serviceService;

    @Before
    public void deleteData() {

    }

    @Test
    public void saveServiceTest() {
        Service service = buildTestService();
        int sizeBefore = serviceService.findAll().size();
        serviceService.save(service);
        assertThat(serviceService.findAll(), hasSize(sizeBefore + 1));
    }

    @Test
    public void updateServiceTest() {

        String changed = "Service2";

        Service service = buildTestService();
        serviceService.save(service);

        service.setName(changed);
        serviceService.update(service);
        Service fetched = serviceService.findById(service.getId());
        assertThat(fetched.getName(), is(changed));
    }

    @Test
    public void deleteServiceTest() {
        Service service = buildTestService();
        serviceService.save(service);

        serviceService.delete(service.getId());
        assertThat(serviceService.findAll(), hasSize(0));

    }

    @Test
    public void updateActiveTest() {
        Service service = buildTestService();
        serviceService.save(service);
        System.out.println("1: " + service.getId());
        service.setDeleted(true);
        assertNotNull(serviceService.findById(service.getId()));
        System.out.println("2: " + serviceService.update(service).getId());
        assertNull(serviceService.findById(service.getId()));

        service.setDeleted(false);

    }

    @Test
    public void addMoneyTestTest() {
        Service service = buildTestService();
        Money UAH = new Money(Currency.UAH, 100L);
        Money USD = new Money(Currency.USD, 100L);
        System.out.println(UAH.getCurrency());
        System.out.println(USD.getCurrency());
        service.getPrices().add(UAH);
        service.getPrices().add(USD);

        System.out.println(service.getId());
        serviceService.save(service);
        System.out.println(service.getId());
        assertThat(serviceService.findById(service.getId()).getPrices(), hasSize(2));

    }
}
