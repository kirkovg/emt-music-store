package mk.ukim.finki.emt.musicstore.service.custom;


import mk.ukim.finki.emt.musicstore.domain.Instrument;
import org.springframework.data.domain.Page;

import java.util.List;

public interface QueryService {

    Page<Instrument> getInstrumentsInCategory(Long categoryId, Integer page, Integer pageSize);

    Page<Instrument> getPromotedInstruments(Integer page, Integer pageSize);

    List<Instrument> searchInstrument(String query);
}
