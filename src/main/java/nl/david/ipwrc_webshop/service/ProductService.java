package nl.david.ipwrc_webshop.service;
import nl.david.ipwrc_webshop.DTO.AddProductDTO;
import nl.david.ipwrc_webshop.model.Product;
import nl.david.ipwrc_webshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductsByCategoryId(Long categoryId) {
        return productRepository.findByCategory_categoryId(categoryId);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public boolean validateAndSaveProduct(AddProductDTO addproductRequest){
        Product product = new Product();
        product.setName(addproductRequest.getName());
        product.setDescription(addproductRequest.getDescription());
        product.setPrice(addproductRequest.getPrice());
        product.setQuantityInStock(addproductRequest.getQuantityInStock());
        String imageName = UUID.randomUUID().toString() + ".png";
        if(!saveImage(addproductRequest.getImage(), imageName)){
            return false;
        }
        product.setImageUrl("http://localhost:8080/static/"+imageName);
        productRepository.save(product);
        return true;
    }

    private boolean saveImage(String base64Image, String fileName) {
        try {
            String base64Data = base64Image.replaceAll("^data:[^;]+;base64,", "");
            byte[] imageBytes = Base64.getDecoder().decode(base64Data);
            String filePath = "src/main/resources/static/"+fileName;
            FileOutputStream outputStream = new FileOutputStream(filePath);
            outputStream.write(imageBytes);
            outputStream.close();
            return true;
        } catch (Exception e) {
            System.out.println("message: " + e.getMessage());
            e.printStackTrace();
           return false;
        }
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
