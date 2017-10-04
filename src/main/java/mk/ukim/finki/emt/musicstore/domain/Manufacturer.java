package mk.ukim.finki.emt.musicstore.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "manufacturers")
@EqualsAndHashCode(callSuper=false)
public class Manufacturer extends BaseEntity {

    private String name;

    private String website;
}
