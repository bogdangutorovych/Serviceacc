package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.Contact;

import java.util.List;

/**
 * Created by andreb on 30.03.17.
 */
public interface ContactRepository extends JpaRepository<Contact, Long>, JpaSpecificationExecutor {
    List<Contact> findByClient(Client client);
}
