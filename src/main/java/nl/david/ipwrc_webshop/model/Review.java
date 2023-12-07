package nl.david.ipwrc_webshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @Column(name = "id", nullable = false)
    private long reviewId;
    @ManyToOne
    @JoinColumn(name = "account")
    private Account reviewer;
    private String comment;
    private int rating;
    private Date reviewDate;
    private boolean checkedByAdmin;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

}
