package dev.sana.EcomProductService.Service;

import dev.sana.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.sana.EcomProductService.DTO.ProductResponseDTO;
import dev.sana.EcomProductService.Entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductResponseDTO> getAllProducts();

    Product getProduct(int productId);

    Product createProduct(Product product);

    Product updateProduct(Product updatedProduct, int productId);

    boolean deleteProduct(int productId);
}
