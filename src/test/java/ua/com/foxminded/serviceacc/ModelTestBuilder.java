package ua.com.foxminded.serviceacc;

import ua.com.foxminded.serviceacc.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by andreb on 09.04.17.
 *
 */
public class ModelTestBuilder {

    public static final String BEGINNER = "Beginner";
    public static final String APPLICANT = "Applicant";
    public static final String REGULAR = "Regular";

    public static final String ACTIVE = "Active";
    public static final String FROZEN = "Frozen";
    public static final String PENDING = "Pending";

    public static final String MOBILE = "Mobile";
    public static final String EMAIL = "Email";
    public static final String ADDRESS = "Address";
    public static final String SKYPE = "Skype";
    public static final String OTHER = "Other";
    
    public static final String DOLLAR = "Dollar";
    public static final String HRYVNIA = "Hryvnia";
    public static final String RUBLE = "Ruble";



    public static Client buildTestClient(){
        Client client = new Client();
        client.setStatus(null);
        client.setLevel(null);
        client.setManager(null);

        return client;
    }

    public static Manager buildTestManager(){

        Client client = buildTestClient();

        Manager manager = new Manager();
        manager.getClients().add(client);

        return manager;
    }

    public static ClientStatusHistory buildTestClientHistory(Client client, ClientStatusType changedStatus){
        ClientStatusHistory clientStatusHistory = new ClientStatusHistory(client, changedStatus, new Date());

        return clientStatusHistory;
    }

    public static List<ClientStatusType> buildListTestClientStatusType(){
        List<ClientStatusType> statuses = new ArrayList<>();
        ClientStatusType active = new ClientStatusType("001", ACTIVE);
        ClientStatusType frozen = new ClientStatusType("002", FROZEN);
        ClientStatusType pending = new ClientStatusType("003", PENDING);
        statuses.add(active);
        statuses.add(frozen);
        statuses.add(pending);
        return statuses;
    }

    public static List<ClientLevelType> buildListTestClientLevelType(){
        List<ClientLevelType> levels = new ArrayList<>();
        levels.add(new ClientLevelType("001", BEGINNER));
        levels.add(new ClientLevelType("002", APPLICANT));
        levels.add(new ClientLevelType("003", REGULAR));

        return levels;
    }
    
    public static List<CurrencyType> buildListTestCurrencyType(){
        List<CurrencyType> levels = new ArrayList<>();
        levels.add(new CurrencyType("USA", DOLLAR));
        levels.add(new CurrencyType("UAH", HRYVNIA));
        levels.add(new CurrencyType("RUB", RUBLE));

        return levels;
    }

}
