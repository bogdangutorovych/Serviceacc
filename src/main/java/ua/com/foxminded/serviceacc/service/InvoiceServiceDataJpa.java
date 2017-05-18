package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.Invoice;
import ua.com.foxminded.serviceacc.repository.InvoiceRepository;

@Service("invoiceService")
public class InvoiceServiceDataJpa implements InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public Invoice create(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice update(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice findById(Long invoiceId) {
        return invoiceRepository.findOne(invoiceId);
    }

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public void delete(Long invoiceId) {
        invoiceRepository.delete(invoiceId);

    }

    @Override
    public List<Invoice> findInvoicesByContractId(Long contractId) {
        return invoiceRepository.findInvoicesByContractId(contractId);
    }

    @Override
    public Invoice findMaxDateInvoice(Long contractID) {
        return invoiceRepository.findMaxDateInvoice(contractID);
    }

}
