package mk.ukim.finki.emt.musicstore.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Table(name = "instrument_ratings")
@Entity
@EqualsAndHashCode(callSuper=false)
public class InstrumentRating extends BaseEntity {

    @Range(min = 1, max = 5)
    private Integer rating;

    @OneToOne
    private Instrument instrument;

    @Column(length = 5000)
    private String comments;

}
