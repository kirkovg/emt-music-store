package mk.ukim.finki.emt.musicstore.service.custom;


import mk.ukim.finki.emt.musicstore.domain.exceptions.NotEnoughStockException;

public interface StockServiceHelper {

    void addInstrumentInStock(Long instrumentId, Integer quantity);

    void removeInstrumentFromStock(Long instrumentId, Integer quantity) throws NotEnoughStockException;
}
