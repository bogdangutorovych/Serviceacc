package ua.com.foxminded.serviceacc.repository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.com.foxminded.serviceacc.config.PersistenceConfig;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.model.Person;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

/**
 * Created by andreb on 31.03.17.
 * Integration Test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
public class ManagerRepositoryTest {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    ManagerRepository managerRepository;

    @After
    public void deleteData(){
        managerRepository.deleteAll();
        clientRepository.deleteAll();
        personRepository.deleteAll();
        contactRepository.deleteAll();
    }

    @Test
    public void saveManager(){
        Manager manager = ModelBuilder.buildTestManager();
        personRepository.save(manager.getPerson());
        managerRepository.save(manager);
        assertThat(managerRepository.findAll(), hasSize(1));
    }

    @Test
    public void addNewClientToManager(){
        Manager manager = ModelBuilder.buildTestManager();
        personRepository.save(manager.getPerson());
        Manager fetched = managerRepository.save(manager);
        assertThat(managerRepository.findAll(), hasSize(1));
        assertThat(fetched.getClients(), hasSize(1));
        //Add new Client
        Person person2 = ModelBuilder.buildTestPerson();
        person2.setFirstName("FFF");
        person2.setLastName("LLL");
        Client client2 = ModelBuilder.buildTestClient();
        client2.setPerson(person2);
        fetched.getClients().add(client2);
        personRepository.save(person2);
        clientRepository.save(client2);
        fetched = managerRepository.save(fetched);
        assertThat(managerRepository.findAll(), hasSize(1));
        assertThat(fetched.getClients(), hasSize(2));
    }

    @Test
    public void deleteManager(){
        Manager manager = ModelBuilder.buildTestManager();
        personRepository.save(manager.getPerson());
        managerRepository.save(manager);
        assertThat(managerRepository.findAll(), hasSize(1));
        managerRepository.delete(manager.getId());
        assertThat(managerRepository.findAll(), hasSize(0));
    }
}
