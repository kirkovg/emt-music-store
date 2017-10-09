package mk.ukim.finki.emt.musicstore.service.custom.impl;


import mk.ukim.finki.emt.musicstore.domain.Category;
import mk.ukim.finki.emt.musicstore.domain.Instrument;
import mk.ukim.finki.emt.musicstore.domain.InstrumentRating;
import mk.ukim.finki.emt.musicstore.repository.CategoryRepository;
import mk.ukim.finki.emt.musicstore.repository.InstrumentRatingRepository;
import mk.ukim.finki.emt.musicstore.repository.InstrumentRepository;
import mk.ukim.finki.emt.musicstore.repository.ManufacturerRepository;
import mk.ukim.finki.emt.musicstore.service.custom.InstrumentServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class InstrumentServiceHelperImpl implements InstrumentServiceHelper {

    private InstrumentRepository instrumentRepository;
    private InstrumentRatingRepository instrumentRatingRepository;
    private CategoryRepository categoryRepository;
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    public InstrumentServiceHelperImpl(InstrumentRepository instrumentRepository,
                                       InstrumentRatingRepository instrumentRatingRepository,
                                       CategoryRepository categoryRepository,
                                       ManufacturerRepository manufacturerRepository) {
        this.instrumentRepository = instrumentRepository;
        this.instrumentRatingRepository = instrumentRatingRepository;
        this.categoryRepository = categoryRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public InstrumentRating getInstrumentRating(Long instrumentId) {
        return null;
    }

    @Override
    public InstrumentRating updateInstrumentRating(Long instrumentId, Integer rating) {
        return null;
    }

    @Override
    public Instrument getInstrument(Long instrumentId) {
        return instrumentRepository.findOne(instrumentId);
    }

    @Override
    public Instrument updateInstrumentCategory(Long instrumentId, Long newCategoryId) {
        Instrument instrument = instrumentRepository.findOne(instrumentId);
        Category newCategory = categoryRepository.findOne(newCategoryId);
        instrument.setCategory(newCategory);
        return instrumentRepository.save(instrument);
    }

    @Override
    public Instrument createInstrument(String name, BigDecimal price, Boolean promoted, String itemNumber, Long categoryId, Long manufacturerId) {
        Instrument instrument = new Instrument();
        instrument.setName(name);
        instrument.setPrice(price);
        instrument.setPromoted(promoted);
        instrument.setItemNumber(itemNumber);
        instrument.setQuantityInStock(0);
        instrument.setCategory(categoryRepository.findOne(categoryId));
        instrument.setManufacturer(manufacturerRepository.findOne(manufacturerId));
        return instrumentRepository.save(instrument);
    }

    @Override
    public Instrument updateInstrument(Long id, String name, BigDecimal price, Boolean promoted, String itemNumber, Long categoryId, Long manufacturerId) {
        Instrument instrument = instrumentRepository.findOne(id);
        instrument.setName(name);
        instrument.setName(name);
        instrument.setPrice(price);
        instrument.setPromoted(promoted);
        instrument.setItemNumber(itemNumber);
        instrument.setCategory(categoryRepository.findOne(categoryId));
        instrument.setManufacturer(manufacturerRepository.findOne(manufacturerId));
        return instrument;
    }
}
