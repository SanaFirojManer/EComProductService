package dev.sana.EcomProductService.ServiceImpl;

import dev.sana.EcomProductService.Client.FakeStoreClient;
import dev.sana.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.sana.EcomProductService.Entity.Product;
import dev.sana.EcomProductService.Exception.NoProductPresentException;
import dev.sana.EcomProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductServiceImpl {

    @Autowired
    private FakeStoreClient fakeStoreClient;

    public List<FakeStoreProductResponseDTO> getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProducts = fakeStoreClient.getAllProducts();
        if(fakeStoreProducts == null){
            throw new NoProductPresentException("No products are found");
        }
        return fakeStoreProducts;
    }



    public Product getProduct(int productId) {
        return null;
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
