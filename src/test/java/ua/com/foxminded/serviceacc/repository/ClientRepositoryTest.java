package ua.com.foxminded.serviceacc.repository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.com.foxminded.serviceacc.config.PersistenceConfig;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.ClientLevelType;
import ua.com.foxminded.serviceacc.model.ClientStatusType;
import ua.com.foxminded.serviceacc.model.Manager;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by andreb on 30.03.17.
 * Integration Test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
public class ClientRepositoryTest {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    ClientLevelTypeRepository clientLevelTypeRepository;
    @Autowired
    ClientStatusTypeRepository clientStatusTypeRepository;
    @Autowired
    ManagerRepository managerRepository;

    @After
    public void deleteData(){
        managerRepository.deleteAll();
        clientRepository.deleteAll();
        personRepository.deleteAll();
        contactRepository.deleteAll();
        clientLevelTypeRepository.deleteAll();
        clientStatusTypeRepository.deleteAll();
    }

    @Test
    public void saveClient(){
        Client client = ModelBuilder.buildTestClient();
        personRepository.save(client.getPerson());
        clientRepository.save(client);
        assertThat(clientRepository.findAll(), hasSize(1));
    }

    @Test
    public void updateClient(){
        Client client = ModelBuilder.buildTestClient();
        personRepository.save(client.getPerson());
        clientRepository.save(client);
        assertThat(clientRepository.findAll(), hasSize(1));

//        client.setLevel(new ClientLevelType("Regular"));
//        client.setStatus(new ClientStatusType("Frozen"));
        clientRepository.save(client);
        Client fetched = clientRepository.findOne(client.getId());
//        assertThat(fetched.getLevel(), is(new ClientLevelType("Regular")));
//        assertThat(fetched.getStatus().getStatus(), is(new ClientStatusType("Frozen")));
//        assertThat(fetched.getStatus(), not(ClientStatus.Active));
    }

    @Test
    public void deleteClient(){
        Client client = ModelBuilder.buildTestClient();
        personRepository.save(client.getPerson());
        clientRepository.save(client);
        assertThat(clientRepository.findAll(), hasSize(1));
        clientRepository.delete(client);
        assertThat(clientRepository.findAll(), hasSize(0));
    }

    @Test
    public void fetchClientWithPersonLevelStatus(){
        Client client = ModelBuilder.buildTestClient();

        ClientLevelType regular = new ClientLevelType(ModelBuilder.REGULAR);
        clientLevelTypeRepository.save(regular);
        client.setLevel(regular);

        ClientStatusType active = new ClientStatusType("001", ModelBuilder.ACTIVE);
        clientStatusTypeRepository.save(active);
        client.setStatus(active);

        personRepository.save(client.getPerson());
        clientRepository.save(client);

        Manager manager = ModelBuilder.buildTestManager();
        personRepository.save(manager.getPerson());
        managerRepository.save(manager);

        client.setManager(manager);
        clientRepository.save(client);

        manager.getClients().add(client);
        managerRepository.save(manager);

        List<Client> clientList = clientRepository.findAllAndFetchEagerly();
        Client fetched= clientList.get(0);

        System.out.println(fetched);

    }


}
