package ua.com.foxminded.serviceacc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	ClientService clientService;
	@Autowired
	ContractStatusService contractStatusService;
	@Autowired
	ManagerService managerService;
	@Autowired
	CurrencyTypeService currencyTypeService;

	@Test
	public void findAllFetch() {

	}
}
