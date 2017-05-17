package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.serviceacc.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
