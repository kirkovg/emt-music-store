package mk.ukim.finki.emt.musicstore.repository;

import mk.ukim.finki.emt.musicstore.domain.InstrumentDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentDetailsRepository extends CrudRepository<InstrumentDetails, Long> {

    InstrumentDetails findInstrumentDetailsByInstrumentId(Long instrumentId);
}
