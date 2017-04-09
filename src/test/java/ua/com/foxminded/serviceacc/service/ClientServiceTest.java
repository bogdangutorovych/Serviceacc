package ua.com.foxminded.serviceacc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.ClientLevelType;
import ua.com.foxminded.serviceacc.model.ClientStatusType;
import ua.com.foxminded.serviceacc.model.Manager;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static ua.com.foxminded.serviceacc.ModelTestBuilder.*;

/**
 * Created by andreb on 09.04.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class ClientServiceTest {

    @Autowired
    ClientService clientService;
    @Autowired
    PersonService personService;
    @Autowired
    ClientLevelTypeService clientLevelTypeService;
    @Autowired
    ClientStatusTypeService clientStatusTypeService;
    @Autowired
    ManagerService managerService;

    @Test
    public void findAllFetch() {
        List<ClientLevelType> levels = buildListTestClientLevelType();
        List<ClientStatusType> statuses = buildListTestClientStatusType();
        for (int i = 0; i<3; i++){
            Client client = buildTestClient();
            ClientLevelType level = clientLevelTypeService.save(levels.get(i));
            client.setLevel(level);
            ClientStatusType status = clientStatusTypeService.save(statuses.get(i));
            client.setStatus(status);

            Manager manager = buildTestManager();
            personService.create(manager.getPerson());
            managerService.create(manager);
            client.setManager(manager);

            personService.create(client.getPerson());
            clientService.create(client);
            manager.getClients().add(client);
            managerService.update(manager);
        }
        assertThat(clientService.findAll(), hasSize(3));
        assertThat(managerService.findAll(), hasSize(3));
        assertThat(clientLevelTypeService.findAll(), hasSize(3));
        assertThat(clientStatusTypeService.findAll(), hasSize(3));

    }
}
