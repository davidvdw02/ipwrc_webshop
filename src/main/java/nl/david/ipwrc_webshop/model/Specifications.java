package nl.david.ipwrc_webshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "specifications")
public class Specifications {
    @Id
    @Column(name = "id", nullable = false)
    private String name;
    private double height;
    private double weight;
    private double width;
    private double depth;
    private boolean isWaterproof;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
