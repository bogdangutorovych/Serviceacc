package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.Invoice;

public interface InvoiceService {

    Invoice create(Invoice invoice);

    Invoice update(Invoice invoice);

    Invoice findById(Long invoiceId);

    List<Invoice> findAll();

    void delete(Long invoiceId);

    List<Invoice> findInvoicesByContractId(Long contractId);

    Invoice findMaxDateInvoice(Long contractID);

}
