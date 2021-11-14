package com.geekbrains.springwebhomework3.repository;

import com.geekbrains.springwebhomework3.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductsRepository {
    private final int MAX_PRODUCTS_COUNT = 10;
    private List<Product> productsList;

    @PostConstruct
    public void init(){
        productsList = new ArrayList<>();
        for (int i = 0; i < MAX_PRODUCTS_COUNT; i++) {
            productsList.add(new Product((long) i + 1));
        }
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public Product getByID(Long id){
        return productsList.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Item with id %011d not found", id)));
    }
}
