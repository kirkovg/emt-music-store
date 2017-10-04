package mk.ukim.finki.emt.musicstore.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "checkouts")
public class Checkout extends BaseEntity {

    @OneToOne
    private Cart cart;

    @ManyToOne
    private DeliveryInfo deliveryInfo;

    @ManyToOne
    private ContactInfo contactInfo;


}
