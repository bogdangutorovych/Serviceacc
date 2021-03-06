package ua.com.foxminded.serviceacc;

import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.ClientInformation;
import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.model.Service;

/**
 * Created by andreb on 09.04.17.
 *
 */
public class ModelTestBuilder {

    public static final String MOBILE = "Mobile";
    public static final String EMAIL = "Email";
    public static final String ADDRESS = "Address";
    public static final String SKYPE = "Skype";
    public static final String OTHER = "Other";

    public static final String DOLLAR = "Dollar";
    public static final String HRYVNIA = "Hryvnia";
    public static final String RUBLE = "Ruble";

    public static final String CONTENT = "CODE";
    public static final String CODE = "some data";

    public static Client buildTestClient() {
        Client client = new Client();
        client.setDeleted(false);
        return client;
    }

    public static ClientInformation buildTestClientInformation() {
        ClientInformation infos = new ClientInformation();
        infos.setDeleted(true);
        return infos;
    }

    public static Manager buildTestManager() {
        Manager manager = new Manager();
        return manager;
    }

    public static Service buildTestService() {
        Service service = new Service();
        service.setName("Service1");
        return service;
    }

}
