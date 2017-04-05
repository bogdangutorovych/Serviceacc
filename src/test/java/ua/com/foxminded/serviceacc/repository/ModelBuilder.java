package ua.com.foxminded.serviceacc.repository;

import ua.com.foxminded.serviceacc.model.*;
import java.util.Date;

/**
 * Created by andreb on 30.03.17.
 */
public class ModelBuilder {

    public static Contact buildTestContact(){
        Contact contact = new Contact();
        contact.setContactName("066-123-45-67");
        contact.setContactType(new ContactType());
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
        client.setStatus(new ClientStatusType());
        client.setLevel(new ClientLevelType());
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


}
