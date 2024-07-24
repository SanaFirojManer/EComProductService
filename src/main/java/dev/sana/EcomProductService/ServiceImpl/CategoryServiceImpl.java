package dev.sana.EcomProductService.ServiceImpl;

import dev.sana.EcomProductService.DTO.CategoryResponseDTO;
import dev.sana.EcomProductService.DTO.CreateCategoryRequestDTO;
import dev.sana.EcomProductService.Entity.Category;
import dev.sana.EcomProductService.Exception.CategoryNotFoundException;
import dev.sana.EcomProductService.Mapper.CategoryEntityDTOMapper;
import dev.sana.EcomProductService.Repository.CategoryRepository;
import dev.sana.EcomProductService.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDTO getCategory(UUID categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new CategoryNotFoundException("Category not found for id: " + categoryId));
        return CategoryEntityDTOMapper.convertCategoryToCategoryResponseDTO(category);
    }

    @Override
    public List<CategoryResponseDTO> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponseDTO> categoryResponseDTOS = new ArrayList<>();
        for(Category category : categories){
            categoryResponseDTOS.add(CategoryEntityDTOMapper.convertCategoryToCategoryResponseDTO(category));
        }
        return categoryResponseDTOS;
    }

    @Override
    public CategoryResponseDTO createCategory(CreateCategoryRequestDTO categoryRequestDTO) {
        Category category = CategoryEntityDTOMapper.convertCreateCategoryDTOToCategory(categoryRequestDTO);
        category = categoryRepository.save(category);
        return CategoryEntityDTOMapper.convertCategoryToCategoryResponseDTO(category);
    }

    @Override
    public CategoryResponseDTO updateCategory(CreateCategoryRequestDTO categoryRequestDTO, UUID categoryId) {
        return null;
    }

    @Override
    public boolean deleteCategory(UUID categoryId) {
        return false;
    }
}
