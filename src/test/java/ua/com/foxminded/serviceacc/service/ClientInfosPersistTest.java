package ua.com.foxminded.serviceacc.service;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static ua.com.foxminded.serviceacc.ModelTestBuilder.buildTestClient;
import static ua.com.foxminded.serviceacc.ModelTestBuilder.buildTestClientInformation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import ua.com.foxminded.serviceacc.ModelTestBuilder;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.ClientInformation;
import ua.com.foxminded.serviceacc.model.ClientInformationType;

/**
 * Created by andreb on 17.04.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ClientInfosPersistTest {

    @Autowired
    ClientService clientService;
    @Autowired
    ManagerService managerService;
    @Autowired
    ClientInformationTypeService clientInformationTypeService;
    @Autowired
    ClientInformationService clientInformationService;

    @Test
    public void saveClientWithInfos() {

        String typeName = "Skype2";
        String typeCode = "SKP2";
        // Save new type and check
        ClientInformationType skype1 = new ClientInformationType(typeCode, typeName);
        skype1.setActive(true);
        clientInformationTypeService.save(skype1);
        assertThat(skype1.getTitle(), is(typeName));

        Client client = ModelTestBuilder.buildTestClient();
        client.setActive(true);
        clientService.save(client);

        ClientInformation info1 = new ClientInformation();
        info1.setClientInformationType(skype1);
        info1.setContent("oneone");
        info1.setActive(true);
        info1.setClient(client);
        clientInformationService.save(info1);

        ClientInformation info2 = new ClientInformation();
        info2.setClientInformationType(skype1);
        info2.setContent("twotwo");
        info2.setActive(true);
        info2.setClient(client);
        clientInformationService.save(info2);

        assertThat(clientInformationService.findByClient(client), hasSize(2));
    }

    @Test
    public void changeAndSaveInfosInClient() {

        ClientInformationType type1 = new ClientInformationType("001", "type1");
        type1.setActive(true);
        clientInformationTypeService.save(type1);

        Client client = buildTestClient();
        clientService.save(client);

        ClientInformation info1 = buildTestClientInformation();
        info1.setContent("content1");
        info1.setClientInformationType(type1);
        info1.setClient(client);
        clientInformationService.save(info1);

        ClientInformation info2 = buildTestClientInformation();
        info2.setContent("content2");
        info2.setClientInformationType(type1);
        info2.setClient(client);
        clientInformationService.save(info2);

        info2.setClient(null);
        clientInformationService.update(info2);

        assertThat(clientInformationService.findByClient(client), hasSize(1));
    }

}
