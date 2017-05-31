package ua.com.foxminded.serviceacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.foxminded.serviceacc.model.Contract;
import ua.com.foxminded.serviceacc.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    String maxDateInvoice = "select x.* from "
            + "(select i.*,  p.date_to, max(p.date_to) over (partition by i.contract_id)  max_date " + "from invoice i "
            + "left join period p on p.id = i.period_id " + "where i.contract_id = ?1) x "
            + "where x.max_date = x.date_to";

    List<Invoice> findByContract(Contract contract);

    @Query(value = maxDateInvoice, nativeQuery = true)
    Invoice findMaxDateInvoice(Long contractID);

}
