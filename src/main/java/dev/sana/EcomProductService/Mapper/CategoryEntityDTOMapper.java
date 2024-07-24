package dev.sana.EcomProductService.Mapper;

import dev.sana.EcomProductService.DTO.CategoryResponseDTO;
import dev.sana.EcomProductService.DTO.CreateCategoryRequestDTO;
import dev.sana.EcomProductService.DTO.ProductResponseDTO;
import dev.sana.EcomProductService.Entity.Category;
import dev.sana.EcomProductService.Entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryEntityDTOMapper {

    public static CategoryResponseDTO convertCategoryToCategoryResponseDTO(Category category){
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setCategoryName(category.getName());
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
        for(Product product : category.getProducts()){
            productResponseDTOS.add(ProductEntityDTOMapper.convertEntityToProductResponseDTO(product));
        }
        categoryResponseDTO.setProducts(productResponseDTOS);
        return categoryResponseDTO;
    }

    public static Category convertCreateCategoryDTOToCategory(CreateCategoryRequestDTO categoryRequestDTO){
        Category category = new Category();
        category.setName(categoryRequestDTO.getCategoryName());
        return category;
    }
}
