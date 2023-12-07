package nl.david.ipwrc_webshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @Column(name = "id", nullable = false)
    private long InvoiceId;
    @OneToOne
    @JoinColumn(name = "order_id", unique = true)
    private Order order;
@ManyToOne
@JoinColumn(name = "account_id")
private Account account;

    private String invoiceAddress;
    private String invoiceCity;
    private String invoicePostalCode;
    private String invoiceCountry;
    private String shippingAddress;
    private String shippingCity;
    private String shippingPostalCode;
    private String shippingCountry;
}
