package nl.david.ipwrc_webshop.DTO;

import lombok.Getter;
import lombok.Setter;
import nl.david.ipwrc_webshop.model.Category;

@Setter
@Getter
public class AddProductDTO {
    private String description;
    private String name;
    private double price;
    private int quantityInStock;
    private String image;
    private Category category;
}