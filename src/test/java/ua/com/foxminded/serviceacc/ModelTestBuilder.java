package ua.com.foxminded.serviceacc;

import ua.com.foxminded.serviceacc.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by andreb on 09.04.17.
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

    public static Contact buildTestContact(){
        Contact contact = new Contact();
        contact.setContactName("066-123-45-67");
        contact.setContactType(null);
        contact.setPerson(null);

        return contact;
    }

    public static Person buildTestPerson(){
        Person person = new Person();
        person.setFirstName("Ivan");
        person.setLastName("Petrov");
        person.setBirthday(new Date());

        Contact contact = buildTestContact();
        contact.setPerson(person);

        return person;
    }

    public static Client buildTestClient(){
        Person person = buildTestPerson();
        Client client = new Client();
        client.setPerson(person);
        client.setStatus(null);
        client.setLevel(null);
        client.setManager(null);

        return client;
    }

    public static Manager buildTestManager(){
        Person person = buildTestPerson();
        person.setFirstName("Andrey");
        person.setFirstName("Sidorov");

        Client client = buildTestClient();

        Manager manager = new Manager();
        manager.setPerson(person);
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

//    public List<ContactType> buildTestContactTypeList(){
//        List<>
//        return contactTypes;
//    }
}
