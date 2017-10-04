package mk.ukim.finki.emt.musicstore.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Riste Stojanov
 */
@Entity
@Table(name = "cart_items")
@Data
@EqualsAndHashCode(callSuper=false)
public class CartItem extends BaseEntity {

    @NotNull
    @Min(value = 1)
    private Integer quantity;

    @ManyToOne
    private Instrument instrument;

    @ManyToOne
    private Cart cart;

}
