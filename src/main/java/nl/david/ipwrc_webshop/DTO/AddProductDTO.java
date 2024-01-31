package nl.david.ipwrc_webshop.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddProductDTO {
    private String description;
    private String name;
    private double price;
    private int quantityInStock;
    private String image;
    }