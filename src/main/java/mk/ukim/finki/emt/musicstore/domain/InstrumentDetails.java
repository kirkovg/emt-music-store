package mk.ukim.finki.emt.musicstore.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Table(name = "instrument_details")
@Entity
@EqualsAndHashCode(callSuper=false)
public class InstrumentDetails extends BaseEntity {

    @Column(length = 5000)
    private String description;

    @OneToOne
    private Instrument instrument;

    @Embedded
    private FileEmbeddable picture;
}
