package ua.com.foxminded.serviceacc.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.ClientInformation;
import ua.com.foxminded.serviceacc.model.ClientInformationType;

public interface ClientInformationRepository extends JpaRepository<ClientInformation, Long> {

    List<ClientInformation> findByClient(Client client);

    void deleteAllByClientInformationType(ClientInformationType type);
}
