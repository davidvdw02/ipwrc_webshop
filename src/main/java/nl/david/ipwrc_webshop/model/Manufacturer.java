package nl.david.ipwrc_webshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "manufacturers")
public class Manufacturer {
    @Id
    @Column(name = "id", nullable = false)
    private long manufacturerId;
    private String contactPerson;
    private String contactEmail;
    private String site;
    @OneToMany(mappedBy = "manufacturer")
    private List<Product> products;
}
