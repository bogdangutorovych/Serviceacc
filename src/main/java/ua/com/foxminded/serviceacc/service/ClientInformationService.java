package ua.com.foxminded.serviceacc.service;

import ua.com.foxminded.serviceacc.model.ClientInformation;
import java.util.List;

/** Created by Grischenko Maxim on 22.04.17. */

public interface ClientInformationService {
    ClientInformation save(ClientInformation clientInformation);

    ClientInformation update(ClientInformation clientInformation);

    ClientInformation findById(Long clientInformationId);

    List<ClientInformation> findAll();

    void delete(Long clientInformationId);
}
