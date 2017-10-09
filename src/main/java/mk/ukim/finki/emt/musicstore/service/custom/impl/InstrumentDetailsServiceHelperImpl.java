package mk.ukim.finki.emt.musicstore.service.custom.impl;


import mk.ukim.finki.emt.musicstore.domain.FileEmbeddable;
import mk.ukim.finki.emt.musicstore.domain.InstrumentDetails;
import mk.ukim.finki.emt.musicstore.repository.InstrumentDetailsRepository;
import mk.ukim.finki.emt.musicstore.repository.InstrumentRepository;
import mk.ukim.finki.emt.musicstore.service.custom.InstrumentDetailsServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.SQLException;

@Service
public class InstrumentDetailsServiceHelperImpl implements InstrumentDetailsServiceHelper {

    private InstrumentDetailsRepository instrumentDetailsRepository;
    private InstrumentRepository instrumentRepository;

    @Autowired
    public InstrumentDetailsServiceHelperImpl(InstrumentDetailsRepository instrumentDetailsRepository, InstrumentRepository instrumentRepository) {
        this.instrumentDetailsRepository = instrumentDetailsRepository;
        this.instrumentRepository = instrumentRepository;
    }

    @Override
    public InstrumentDetails getInstrumentDetails(Long instrumentId) {
        return instrumentDetailsRepository.findInstrumentDetailsByInstrumentId(instrumentId);
    }

    @Override
    public InstrumentDetails addInstrumentDetails(Long instrumentId,
      byte[] content,
      String contentType,
      String description
    ) throws SQLException {
        InstrumentDetails instrumentDetails = new InstrumentDetails();
        instrumentDetails.setInstrument(instrumentRepository.findOne(instrumentId));
        FileEmbeddable picture = new FileEmbeddable();
        picture.setData(new SerialBlob(content));
        picture.setSize(content.length);
        picture.setContentType(contentType);
        picture.setFileName(instrumentDetails.getInstrument().getName());
        instrumentDetails.setPicture(picture);
        instrumentDetails.setDescription(description);
        return instrumentDetailsRepository.save(instrumentDetails);
    }

    @Override
    public InstrumentDetails updateInstrumentDetails(Long instrumentId,
      byte[] content,
      String contentType,
      String description
    ) throws SQLException {
        InstrumentDetails instrumentDetails =
                instrumentDetailsRepository.findInstrumentDetailsByInstrumentId(instrumentId);
        instrumentDetails.setInstrument(instrumentRepository.findOne(instrumentId));
        FileEmbeddable picture = new FileEmbeddable();
        picture.setData(new SerialBlob(content));
        picture.setSize(content.length);
        picture.setContentType(contentType);
        picture.setFileName(instrumentDetails.getInstrument().getName());
        instrumentDetails.setPicture(picture);
        instrumentDetails.setDescription(description);
        return instrumentDetailsRepository.save(instrumentDetails);
    }

    @Override
    public void removeInstrumentDetails(Long instrumentId) {
        InstrumentDetails instrumentDetails =
                instrumentDetailsRepository.findInstrumentDetailsByInstrumentId(instrumentId);
        instrumentDetailsRepository.delete(instrumentDetails);
    }
}
