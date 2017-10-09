package mk.ukim.finki.emt.musicstore.service.custom;

import mk.ukim.finki.emt.musicstore.domain.InstrumentDetails;

import java.sql.SQLException;

public interface InstrumentDetailsServiceHelper {

    InstrumentDetails getInstrumentDetails(Long instrumentId);

    InstrumentDetails addInstrumentDetails(
        Long instrumentId,
        byte[] content,
        String contentType,
        String description
    ) throws SQLException;

    InstrumentDetails updateInstrumentDetails(
        Long instrumentId,
        byte[] content,
        String contentType,
        String description
    ) throws SQLException;

    void removeInstrumentDetails(Long instrumentId);
}
