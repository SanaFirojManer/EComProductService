package dev.sana.EcomProductService.ServiceImpl;

import dev.sana.EcomProductService.DTO.CreateProductRequestDTO;
import dev.sana.EcomProductService.DTO.ProductResponseDTO;
import dev.sana.EcomProductService.Entity.Category;
import dev.sana.EcomProductService.Entity.Product;
import dev.sana.EcomProductService.Exception.CategoryNotFoundException;
import dev.sana.EcomProductService.Exception.ProductNotFoundException;
import dev.sana.EcomProductService.Mapper.ProductEntityDTOMapper;
import dev.sana.EcomProductService.Repository.CategoryRepository;
import dev.sana.EcomProductService.Repository.ProductRepository;
import dev.sana.EcomProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> savedProduct = productRepository.findAll();
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
        for(Product product : savedProduct){
            productResponseDTOS.add(ProductEntityDTOMapper.convertEntityToProductResponseDTO(product));
        }
        return productResponseDTOS;
    }

    @Override
    public ProductResponseDTO getProduct(UUID productId) throws ProductNotFoundException {
        //basic code
//        Product saveProduct = productRepository.findById(productId).get();
//        if(saveProduct == null){
//            throw new ProductNotFoundException("product not found for id: " + productId);
//        }
//        return saveProduct;
    Product product = productRepository.findById(productId).orElseThrow(
            ()-> new ProductNotFoundException("Product not found for id: "+ productId)
    );
    return ProductEntityDTOMapper.convertEntityToProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO createProduct(CreateProductRequestDTO productRequestDTO) {
        Product product = ProductEntityDTOMapper.convertCreateProductRequestDTOToProduct(productRequestDTO);
        Category savedCategory = categoryRepository.findById(productRequestDTO.getCategoryId()).orElseThrow(
                () -> new CategoryNotFoundException("Category not found for id: "+ productRequestDTO.getCategoryId())
        );
        product.setCategory(savedCategory);
        product = productRepository.save(product);
        return ProductEntityDTOMapper.convertEntityToProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO updateProduct(CreateProductRequestDTO updatedProduct, UUID productId) {
        Product savedProduct = productRepository.findById(productId).orElseThrow(
                ()-> new ProductNotFoundException("Product not found for id: "+ productId)
        );
        savedProduct.setTitle(updatedProduct.getTitle());
        savedProduct.setImageURL(updatedProduct.getImageURL());
        savedProduct.setPrice(updatedProduct.getPrice());
        savedProduct.setDescription(updatedProduct.getDescription());
        savedProduct = productRepository.save(savedProduct);
        return ProductEntityDTOMapper.convertEntityToProductResponseDTO(savedProduct);
    }

    @Override
    public boolean deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public ProductResponseDTO getProduct(String productName) {
        return ProductEntityDTOMapper.convertEntityToProductResponseDTO(
                productRepository.findProductByTitle(productName)
        );
    }

    @Override
    public List<ProductResponseDTO> getProducts(double minPrice, double maxPrice) {
        List<Product> products = productRepository.findByPriceBetween(minPrice, maxPrice);
        return products.stream()
                .map(ProductEntityDTOMapper::convertEntityToProductResponseDTO)
                .collect(Collectors.toList());

    }

}
