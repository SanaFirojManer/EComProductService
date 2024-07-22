package dev.sana.EcomProductService.Mapper;

import dev.sana.EcomProductService.DTO.ProductResponseDTO;
import dev.sana.EcomProductService.Entity.Product;
import dev.sana.EcomProductService.Service.ProductService;

public class ProductEntityDTOMapper {
    public static ProductResponseDTO convertEntityToProductResponseDTO(Product product){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setTitle(product.getTitle());
        productResponseDTO.setCategory(productResponseDTO.getCategory());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setRating(product.getRating());
        productResponseDTO.setImageURL(product.getImageURL());
        return productResponseDTO;
    }
}
