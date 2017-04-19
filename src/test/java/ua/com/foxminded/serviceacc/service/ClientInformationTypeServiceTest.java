package ua.com.foxminded.serviceacc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.foxminded.serviceacc.model.ClientInformationType;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by andreb on 19.04.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class ClientInformationTypeServiceTest {

    @Autowired
    ClientService clientService;
    @Autowired
    ClientInformationTypeService clientInformationTypeService;

    @Test
    public void saveClientInformation(){
        String typeName = "Skype1";
        String typeCode = "SKP";
        //Save new type and check
        ClientInformationType skype1 = new ClientInformationType(typeCode, typeName);
        skype1.setActive(true);
        clientInformationTypeService.save(skype1);
        assertThat(skype1.getTitle(), is(typeName));
    }
}
