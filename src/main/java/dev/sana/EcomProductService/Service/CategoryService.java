package dev.sana.EcomProductService.Service;

import dev.sana.EcomProductService.DTO.CategoryResponseDTO;
import dev.sana.EcomProductService.DTO.CreateCategoryRequestDTO;
import dev.sana.EcomProductService.Entity.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    CategoryResponseDTO getCategory(UUID categoryId);
    List<CategoryResponseDTO> getAllCategory();
    CategoryResponseDTO createCategory(CreateCategoryRequestDTO categoryRequestDTO);
    CategoryResponseDTO updateCategory(CreateCategoryRequestDTO categoryRequestDTO, UUID categoryId);
    boolean deleteCategory(UUID categoryId);
}
