package mk.ukim.finki.emt.musicstore.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mk.ukim.finki.emt.musicstore.domain.enums.DeliveryStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;


@Data
@EqualsAndHashCode(callSuper=false)
public class DeliveryPackage extends BaseEntity {

    @OneToOne
    private Checkout checkout;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}
