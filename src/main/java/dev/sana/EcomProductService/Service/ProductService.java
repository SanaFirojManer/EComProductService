package dev.sana.EcomProductService.Service;

import dev.sana.EcomProductService.DTO.CreateProductRequestDTO;
import dev.sana.EcomProductService.DTO.ProductResponseDTO;
import dev.sana.EcomProductService.Entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO getProduct(UUID productId);

    ProductResponseDTO createProduct(CreateProductRequestDTO product);

    ProductResponseDTO updateProduct(CreateProductRequestDTO updatedProduct, UUID productId);

    boolean deleteProduct(UUID productId);

    ProductResponseDTO getProduct(String productName);

    List<ProductResponseDTO> getProducts(double minPrice, double maxPrice);
}
