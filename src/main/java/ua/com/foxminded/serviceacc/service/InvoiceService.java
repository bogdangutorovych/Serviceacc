package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.Contract;
import ua.com.foxminded.serviceacc.model.Invoice;

public interface InvoiceService {

    Invoice save(Invoice invoice);

    Invoice findById(Long invoiceId);

    List<Invoice> findAll();

    void delete(Long invoiceId);

    List<Invoice> findByContract(Contract contract);

    Invoice findMaxDateInvoice(Long contractID);

}
