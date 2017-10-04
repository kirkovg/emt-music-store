package mk.ukim.finki.emt.musicstore.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import mk.ukim.finki.emt.musicstore.domain.enums.InvoiceStatus;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "invoices")
@EqualsAndHashCode(callSuper=false)
public class Invoice extends BaseEntity {

    @OneToOne
    private Checkout checkout;

    private BigDecimal grossPrice;

    private BigDecimal taxAmount;

    private LocalDateTime expiryDate;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;
}
