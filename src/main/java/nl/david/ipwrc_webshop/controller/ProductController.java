package nl.david.ipwrc_webshop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import nl.david.ipwrc_webshop.DTO.AddProductDTO;
import nl.david.ipwrc_webshop.model.Product;
import nl.david.ipwrc_webshop.service.ImageValidatorService;
import nl.david.ipwrc_webshop.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @GetMapping("/category/{categoryId}")
    public List<Product> getProductsByCategoryId(@PathVariable Long categoryId) {
        return this.productService.getProductsByCategoryId(categoryId);
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody AddProductDTO addProductRequest) {
        if (ImageValidatorService.validateImage(addProductRequest.getImage())) {
            if (!productService.validateAndSaveProduct(addProductRequest)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("Product created");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Image is not a valid base64 png");
    }

    // @GetMapping("/{id}")
    // public String getProductById(@PathVariable Long id) {
    // // TODO: Implement logic to retrieve product by ID
    // return "Product with ID: " + id;
    // }

    // @PutMapping("/{id}")
    // public String updateProduct(@PathVariable Long id, @RequestBody Product
    // product) {
    // // TODO: Implement logic to update an existing product
    // return "Product updated";
    // }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        this.productService.deleteProduct(id);
    }
}
