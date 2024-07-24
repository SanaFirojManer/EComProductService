package dev.sana.EcomProductService.Controller;

import dev.sana.EcomProductService.DTO.CategoryResponseDTO;
import dev.sana.EcomProductService.DTO.CreateCategoryRequestDTO;
import dev.sana.EcomProductService.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategory(){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable("id")UUID categoryId){
        return ResponseEntity.ok(categoryService.getCategory(categoryId));
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCtegory(@RequestBody CreateCategoryRequestDTO categoryRequestDTO){
        return ResponseEntity.ok(categoryService.createCategory(categoryRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable("id") UUID categoryId, @RequestBody CreateCategoryRequestDTO categoryRequestDTO){
        return ResponseEntity.ok(categoryService.updateCategory(categoryRequestDTO, categoryId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") UUID categoryId){
        return ResponseEntity.ok(categoryService.deleteCategory(categoryId));
    }

}
