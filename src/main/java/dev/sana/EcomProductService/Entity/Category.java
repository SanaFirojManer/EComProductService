package dev.sana.EcomProductService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Category extends BaseModel{
    private String name;

    @OneToMany
    private List<Product> products;

}
