package ua.com.foxminded.serviceacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.ClientInformation;

public interface ClientInformationRepository extends JpaRepository<ClientInformation, Long> {

    public String query = "select ci.* " + "from client_info ci " + "left join client c on c.id = ci.client_id "
            + "left join client_info_type cit on cit.id = ci.info_type_id " +

            "where   c.id = ?1 " + "and ci.id = ?2 ";

    List<ClientInformation> findByClient(Client client);

    @Query(value = query, nativeQuery = true)
    ClientInformation findByTypeAndClient(Long clientId, Long clientInfoTypeId);
}
