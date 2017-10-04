package mk.ukim.finki.emt.musicstore.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "carts")
@Data
@EqualsAndHashCode(callSuper=false)
public class Cart extends BaseEntity {

    private LocalDateTime expiryDate;

    private BigDecimal totalPrice;
}
