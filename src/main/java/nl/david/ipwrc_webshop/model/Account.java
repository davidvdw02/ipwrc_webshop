package nl.david.ipwrc_webshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "accounts")
@Setter
@Getter
public class Account {
    @Id
    @Column(name = "id", nullable = false)
    private long accountId;
    private String username;
    private String password;
    private String email;
    private boolean isAdmin;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Review> reviews;
    @OneToMany(mappedBy = "account")
    private List<Invoice> invoices;
    @OneToMany(mappedBy = "user")
    private List<Order> orders;
    @OneToMany(mappedBy = "reviewer", cascade = CascadeType.ALL)
    private List<Review> reviewsReviewed;

}
