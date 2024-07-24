package dev.sana.EcomProductService.Repository;

import dev.sana.EcomProductService.DTO.CategoryResponseDTO;
import dev.sana.EcomProductService.DTO.CreateCategoryRequestDTO;
import dev.sana.EcomProductService.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

}
