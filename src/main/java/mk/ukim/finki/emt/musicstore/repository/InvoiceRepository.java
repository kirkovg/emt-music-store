package mk.ukim.finki.emt.musicstore.repository;

import mk.ukim.finki.emt.musicstore.domain.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
}
