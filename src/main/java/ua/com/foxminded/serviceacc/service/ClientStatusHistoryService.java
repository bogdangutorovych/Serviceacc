package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.ClientStatusHistory;

/**
 * Created by andreb on 31.03.17.
 */
public interface ClientStatusHistoryService {

    ClientStatusHistory save(ClientStatusHistory clientStatusHistory);

    ClientStatusHistory update(ClientStatusHistory clientStatusHistory);

    ClientStatusHistory findById(Long clientStatusHistoryId);

    List<ClientStatusHistory> findAll();

    void delete(Long clientStatusHistoryId);
}
