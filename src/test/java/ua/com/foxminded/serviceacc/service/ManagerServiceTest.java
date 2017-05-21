package ua.com.foxminded.serviceacc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.Manager;

import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static ua.com.foxminded.serviceacc.ModelTestBuilder.*;

/**
 * Created by andreb on 21.05.17.
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ManagerServiceTest {

    @Autowired
    ManagerService managerService;

    @Test
    public void searchContractByManager(){

        Manager manager = buildTestManager();
        managerService.save(manager);
        assertNotNull(manager);
        assertNotNull(manager.getId());
        List<Client> clients = managerService.findClients(manager);
        assertThat(clients, hasSize(0));
        System.out.println(clients);
    }
}
