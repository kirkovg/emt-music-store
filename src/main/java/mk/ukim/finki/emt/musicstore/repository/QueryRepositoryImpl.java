package mk.ukim.finki.emt.musicstore.repository;

import mk.ukim.finki.emt.musicstore.domain.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class QueryRepositoryImpl implements QueryRepository {

    private InstrumentRepository instrumentRepository;

    @Autowired
    public QueryRepositoryImpl(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    @Override
    public Page<Instrument> findInstrumentsByCategoryPaged(Long categoryId, Integer page, Integer pageSize) {
        return instrumentRepository.findAll(
                (instrument, cq, cb) -> cb.equal(instrument.join("category").get("id"), categoryId),
                new PageRequest(page, pageSize)
        );
    }

    @Override
    public Page<Instrument> findPromotedInstruments(Integer page, Integer pageSize) {
        return instrumentRepository.findAll(
                (instrument, cq, cb) -> cb.equal(instrument.get("promoted"), true),
                new PageRequest(page, pageSize)
        );
    }
}
