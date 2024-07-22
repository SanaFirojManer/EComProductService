package dev.sana.EcomProductService.ServiceImpl;

import dev.sana.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.sana.EcomProductService.DTO.ProductResponseDTO;
import dev.sana.EcomProductService.Entity.Product;
import dev.sana.EcomProductService.Exception.ProductNotFoundException;
import dev.sana.EcomProductService.Repository.ProductRepository;
import dev.sana.EcomProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(UUID productId) throws ProductNotFoundException {
        //basic code
//        Product saveProduct = productRepository.findById(productId).get();
//        if(saveProduct == null){
//            throw new ProductNotFoundException("product not found for id: " + productId);
//        }
//        return saveProduct;
    return productRepository.findById(productId).orElseThrow(
            ()-> new ProductNotFoundException("Product not found for id: "+ productId)
    );
    }

    @Override
    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product updateProduct(Product updatedProduct, UUID productId) {
        Product savedProduct = productRepository.findById(productId).orElseThrow(
                ()-> new ProductNotFoundException("Product not found for id: "+ productId)
        );
        savedProduct.setTitle(updatedProduct.getTitle());
        savedProduct.setCategory(updatedProduct.getCategory());
        savedProduct.setRating(updatedProduct.getRating());
        savedProduct.setImageURL(updatedProduct.getImageURL());
        savedProduct.setPrice(updatedProduct.getPrice());
        savedProduct.setDescription(updatedProduct.getDescription());
        savedProduct = productRepository.save(savedProduct);
        return savedProduct;
    }

    @Override
    public boolean deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public Product getProduct(String productName) {
        return productRepository.findProductByTitle(productName);
    }

    @Override
    public List<Product> getProducts(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice,maxPrice);
    }

}
