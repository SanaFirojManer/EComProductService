package dev.sana.EcomProductService.Controller;

import dev.sana.EcomProductService.DTO.FakeStoreProductResponseDTO;
import dev.sana.EcomProductService.Exception.InvalidInputException;
import dev.sana.EcomProductService.Exception.RandomException;
import dev.sana.EcomProductService.ServiceImpl.FakeStoreProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FakeProductController {
    @Autowired
    FakeStoreProductServiceImpl fakeStoreProductService;

    @GetMapping("/fproducts")
    public ResponseEntity getAll(){
        List<FakeStoreProductResponseDTO> products = fakeStoreProductService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/fproduct/{id}")
    public ResponseEntity getProductById(@PathVariable("id") int id){
        if(id < 1){
            throw new InvalidInputException("Input id is invalide");
        }
        FakeStoreProductResponseDTO product =fakeStoreProductService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/fproductexception")
    public ResponseEntity getProductException(){
        throw new RandomException("Exception from product!");
    }
}
