package mk.ukim.finki.emt.musicstore.repository;

import mk.ukim.finki.emt.musicstore.domain.Instrument;
import org.springframework.data.domain.Page;

public interface QueryRepository {

    Page<Instrument> findInstrumentsByCategoryPaged(Long categoryId, Integer page, Integer pageSize);

    Page<Instrument> findPromotedInstruments(Integer page, Integer pageSize);
}
