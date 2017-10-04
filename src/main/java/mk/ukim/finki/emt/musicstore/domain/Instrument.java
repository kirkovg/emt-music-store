package mk.ukim.finki.emt.musicstore.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "instruments")
@EqualsAndHashCode(callSuper=false)
public class Instrument extends BaseEntity {

    private String name;

    private BigDecimal price;

    private Integer quantityInStock;

    private Boolean promoted;

    private String itemNumber;

    @ManyToOne
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    private Manufacturer manufacturer;
}
