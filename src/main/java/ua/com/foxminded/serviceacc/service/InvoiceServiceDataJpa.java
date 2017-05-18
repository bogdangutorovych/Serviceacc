package ua.com.foxminded.serviceacc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.Invoice;
import ua.com.foxminded.serviceacc.repository.InvoiceRepository;

@Service("invoiceService")
public class InvoiceServiceDataJpa implements InvoiceService {

    @Inject
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

}
