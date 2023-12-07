package nl.david.ipwrc_webshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id", nullable = false)
    private long orderId;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Product> products;
    private Date orderDate;
    private double totalAmount;
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Invoice invoice;

}
