package mk.ukim.finki.emt.musicstore.service.custom.impl;


import mk.ukim.finki.emt.musicstore.domain.Instrument;
import mk.ukim.finki.emt.musicstore.domain.exceptions.NotEnoughStockException;
import mk.ukim.finki.emt.musicstore.repository.InstrumentRepository;
import mk.ukim.finki.emt.musicstore.service.custom.StockServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceHelperImpl implements StockServiceHelper {

    private InstrumentRepository instrumentRepository;

    @Autowired
    public StockServiceHelperImpl(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    @Override
    public void addInstrumentInStock(Long instrumentId, Integer quantity) {
        Instrument instrument = instrumentRepository.findOne(instrumentId);
        if (instrument.getQuantityInStock() == null || instrument.getQuantityInStock() == 0) {
            instrument.setQuantityInStock(quantity);
        } else {
            instrument.setQuantityInStock(instrument.getQuantityInStock() + quantity);
        }

        instrumentRepository.save(instrument);
    }

    @Override
    public void removeInstrumentFromStock(Long instrumentId, Integer quantity) throws NotEnoughStockException {
        Instrument instrument = instrumentRepository.findOne(instrumentId);

        if (instrument.getQuantityInStock() < quantity) {
            throw new NotEnoughStockException();
        } else {
            instrument.setQuantityInStock(instrument.getQuantityInStock() - quantity);
        }

        instrumentRepository.save(instrument);
    }
}
