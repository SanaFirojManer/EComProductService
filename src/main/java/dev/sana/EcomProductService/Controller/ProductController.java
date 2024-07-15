package dev.sana.EcomProductService.Controller;

import dev.sana.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.sana.EcomProductService.DTO.ProductResponseDTO;
import dev.sana.EcomProductService.Entity.Product;
import dev.sana.EcomProductService.Service.ProductService;
import dev.sana.EcomProductService.ServiceImpl.FakeStoreProductServiceImpl;
import jakarta.persistence.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    FakeStoreProductServiceImpl fakeStoreProductService;

    @GetMapping("/products")
    public ResponseEntity getAll(){
        List<FakeStoreProductResponseDTO> products = fakeStoreProductService.getAllProducts();
        return ResponseEntity.ok(products);
    }
}
