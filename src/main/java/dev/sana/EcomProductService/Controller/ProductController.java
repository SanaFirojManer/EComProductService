package dev.sana.EcomProductService.Controller;

import dev.sana.EcomProductService.DTO.CreateProductRequestDTO;
import dev.sana.EcomProductService.DTO.ProductResponseDTO;
import dev.sana.EcomProductService.Entity.Product;
import dev.sana.EcomProductService.Exception.InvalidInputException;
import dev.sana.EcomProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO){
        return ResponseEntity.ok(productService.createProduct(createProductRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("id")UUID id){
        if(id==null){
            throw new InvalidInputException("Input is not correct");
        }
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponseDTO>> getAllProduct(){
        List<ProductResponseDTO> product = productService.getAllProducts();
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") UUID id){
        return ResponseEntity.ok(
                productService.deleteProduct(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") UUID id, @RequestBody CreateProductRequestDTO productRequestDTO)
    {return ResponseEntity.ok(productService.updateProduct(productRequestDTO,id));

    }

    @GetMapping("/name/{productName}")
    public ResponseEntity<ProductResponseDTO> getProductByProductName(@PathVariable("productName") String productName){
        return ResponseEntity.ok(
                productService.getProduct(productName)
        );
    }

    @GetMapping("/{min}/{max}")
    public ResponseEntity<List<ProductResponseDTO>> getProductByPriceRange(@PathVariable("min") double minPrice, @PathVariable("max") double maxPricae){
        return ResponseEntity.ok(
                productService.getProducts(minPrice,maxPricae)
        );
    }
}
