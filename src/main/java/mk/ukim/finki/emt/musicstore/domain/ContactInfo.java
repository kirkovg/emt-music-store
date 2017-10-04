package mk.ukim.finki.emt.musicstore.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "contact_info")
public class ContactInfo extends BaseEntity {

    private String firstName;

    private String lastName;

    private String phone;
}
