package dev.sana.EcomProductService.Controller;

import dev.sana.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.sana.EcomProductService.DTO.ProductResponseDTO;
import dev.sana.EcomProductService.Entity.Product;
import dev.sana.EcomProductService.Exception.InvalidInputException;
import dev.sana.EcomProductService.Service.ProductService;
import dev.sana.EcomProductService.ServiceImpl.FakeStoreProductServiceImpl;
import jakarta.persistence.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product){
        Product savedProduct = productService.createProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable("id")UUID id){
        if(id==null){
            throw new InvalidInputException("Input is not correct");
        }
        Product product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/products")
    public ResponseEntity getAllProduct(){
        List<Product> product = productService.getAllProducts();
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") UUID id){
        return ResponseEntity.ok(
                productService.deleteProduct(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") UUID id, @RequestBody Product product){
       Product updatedProduct = productService.updateProduct(product,id);
        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping("/name/{productName}")
    public ResponseEntity getProductByProductName(@PathVariable("productName") String productName){
        return ResponseEntity.ok(
                productService.getProduct(productName)
        );
    }

    @GetMapping("/{min}/{max}")
    public ResponseEntity getProductByPriceRange(@PathVariable("min") double minPrice, @PathVariable("max") double maxPricae){
        return ResponseEntity.ok(
                productService.getProducts(minPrice,maxPricae)
        );
    }
}
