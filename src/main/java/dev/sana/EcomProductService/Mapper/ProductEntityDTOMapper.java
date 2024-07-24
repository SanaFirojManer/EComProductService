package dev.sana.EcomProductService.Mapper;

import dev.sana.EcomProductService.DTO.CreateProductRequestDTO;
import dev.sana.EcomProductService.DTO.ProductResponseDTO;
import dev.sana.EcomProductService.Entity.Product;
import dev.sana.EcomProductService.Service.ProductService;

public class ProductEntityDTOMapper {
    public static ProductResponseDTO convertEntityToProductResponseDTO(Product product){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setTitle(product.getTitle());
        productResponseDTO.setCategory(product.getCategory().getName());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setRating(product.getRating());
        productResponseDTO.setImageURL(product.getImageURL());
        return productResponseDTO;
    }

    public static Product convertCreateProductRequestDTOToProduct(CreateProductRequestDTO productRequestDTO){
        Product product = new Product();
        product.setTitle(productRequestDTO.getTitle());
        product.setPrice(productRequestDTO.getPrice());
        product.setDescription(productRequestDTO.getDescription());
        product.setRating(productRequestDTO.getRating());
        product.setImageURL(productRequestDTO.getImageURL());
        return product;
    }
}
