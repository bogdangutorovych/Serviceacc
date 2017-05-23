package ua.com.foxminded.serviceacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.foxminded.serviceacc.model.Contract;
import ua.com.foxminded.serviceacc.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    public String maxDateInvoice = "select x.* from (select i.*,  max(i.date) over (partition by i.contract_id)  max_date from invoice i where i.contract_id = ?1) x where x.max_date = x.date";

    List<Invoice> findByContract(Contract contract);

    @Query(value = maxDateInvoice, nativeQuery = true)
    Invoice findMaxDateInvoice(Long contractID);

}
