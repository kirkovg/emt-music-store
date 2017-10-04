package mk.ukim.finki.emt.musicstore.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
@Data
@EqualsAndHashCode(callSuper=false)
public class Category extends BaseEntity {

    private String name;

    @ManyToOne
    private Category parent; // column parent_id
}
