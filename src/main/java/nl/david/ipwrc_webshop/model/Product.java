package nl.david.ipwrc_webshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Setter
@Getter
@Entity
@Table(name = "products")
@AllArgsConstructor
@RequiredArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private boolean available = true;
    private double averageRating;
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Specifications specifications;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
