package ua.com.foxminded.serviceacc.service;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by andreb on 09.04.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ClientServiceTest {

    @Inject
    ClientService clientService;
    @Inject
    ManagerService managerService;

    @Test
    public void findAllFetch() {

    }
}
