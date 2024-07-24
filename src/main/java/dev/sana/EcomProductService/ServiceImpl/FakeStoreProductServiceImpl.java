package dev.sana.EcomProductService.ServiceImpl;

import dev.sana.EcomProductService.Client.FakeStoreClient;
import dev.sana.EcomProductService.DTO.FakeStoreDTOs.FakeStoreProductResponseDTO;
import dev.sana.EcomProductService.Entity.Product;
import dev.sana.EcomProductService.Exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductServiceImpl {



    @Autowired
    private FakeStoreClient fakeStoreClient;

    public List<FakeStoreProductResponseDTO> getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProducts = fakeStoreClient.getAllProducts();
        if(fakeStoreProducts == null){
            throw new ProductNotFoundException("No products are found");
        }
        return fakeStoreProducts;
    }



    public FakeStoreProductResponseDTO getProductById(int productId) {
        FakeStoreProductResponseDTO fakeStoreProduct = fakeStoreClient.getProductById(productId);
        if(fakeStoreProduct == null){
            throw new ProductNotFoundException("Product not found with id: "+ productId);
        }
        return fakeStoreProduct;
    }


    public Product createProduct(Product product) {
        return null;
    }


    public Product updateProduct(Product updatedProduct, int productId) {
        return null;
    }


    public boolean deleteProduct(int productId) {
        return false;
    }
}
