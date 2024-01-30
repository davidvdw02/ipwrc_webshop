package nl.david.ipwrc_webshop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import nl.david.ipwrc_webshop.model.Product;
import nl.david.ipwrc_webshop.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {

        return this.productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable Long id) {
        // TODO: Implement logic to retrieve product by ID
        return "Product with ID: " + id;
    }

    @PostMapping
    public String createProduct(@RequestBody Product product) {
        // TODO: Implement logic to create a new product
        return "Product created";
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody Product product) {
        // TODO: Implement logic to update an existing product
        return "Product updated";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        // TODO: Implement logic to delete a product
        return "Product deleted";
    }
}

