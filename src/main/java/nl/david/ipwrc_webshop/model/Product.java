package nl.david.ipwrc_webshop.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    private long productId;
    private String name;
    private String description;
    private double price;
    private int quantityInStock;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String imageUrl;
    private boolean available;
    private double averageRating;
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Specifications specifications;
@ManyToOne
@JoinColumn(name = "order_id")
private Order order;
}
