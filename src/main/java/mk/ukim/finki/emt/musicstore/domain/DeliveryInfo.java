package mk.ukim.finki.emt.musicstore.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "delivery_info")
public class DeliveryInfo extends BaseEntity {

    private String country;

    private String city;

    private String postalCode;

    private String address;

    @ManyToOne
    private User customer;

}
