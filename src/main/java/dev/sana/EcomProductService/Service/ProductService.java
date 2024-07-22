package dev.sana.EcomProductService.Service;

import dev.sana.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.sana.EcomProductService.DTO.ProductResponseDTO;
import dev.sana.EcomProductService.Entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProduct(UUID productId);

    Product createProduct(Product product);

    Product updateProduct(Product updatedProduct, UUID productId);

    boolean deleteProduct(UUID productId);

    Product getProduct(String productName);

    List<Product> getProducts(double minPrice, double maxPrice);
}
