package mk.ukim.finki.emt.musicstore.service.custom;


import mk.ukim.finki.emt.musicstore.domain.Instrument;
import mk.ukim.finki.emt.musicstore.domain.InstrumentRating;

import java.math.BigDecimal;

public interface InstrumentServiceHelper {
    InstrumentRating getInstrumentRating(Long instrumentId);

    InstrumentRating updateInstrumentRating(Long instrumentId, Integer rating);

    Instrument getInstrument(Long instrumentId);

    Instrument updateInstrumentCategory(Long instrumentId, Long newCategoryId);

    Instrument createInstrument(
        String name,
        BigDecimal price,
        Boolean promoted,
        String itemNumber,
        Long categoryId,
        Long manufacturerId
    );

    Instrument updateInstrument(
        Long id,
        String name,
        BigDecimal price,
        Boolean promoted,
        String itemNumber,
        Long categoryId,
        Long manufacturerId
    );
}
