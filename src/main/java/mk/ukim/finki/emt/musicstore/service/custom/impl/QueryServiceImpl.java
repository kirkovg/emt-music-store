package mk.ukim.finki.emt.musicstore.service.custom.impl;


import mk.ukim.finki.emt.musicstore.domain.Instrument;
import mk.ukim.finki.emt.musicstore.repository.QueryRepository;
import mk.ukim.finki.emt.musicstore.repository.SearchRepository;
import mk.ukim.finki.emt.musicstore.service.custom.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryServiceImpl implements QueryService {

    private SearchRepository searchRepository;
    private QueryRepository queryRepository;

    @Autowired
    public QueryServiceImpl(SearchRepository searchRepository, QueryRepository queryRepository) {
        this.searchRepository = searchRepository;
        this.queryRepository = queryRepository;
    }

    @Override
    public Page<Instrument> getInstrumentsInCategory(Long categoryId, Integer page, Integer pageSize) {
        return queryRepository.findInstrumentsByCategoryPaged(categoryId, page, page);
    }

    @Override
    public Page<Instrument> getPromotedInstruments(Integer page, Integer pageSize) {
        return queryRepository.findPromotedInstruments(page, page);
    }

    @Override
    public List<Instrument> searchInstrument(String query) {
        return searchRepository.searchPhrase(
                Instrument.class,
                query,
                "name", "itemNumber", "category.name", "manufacturer.name"
        );
    }
}
