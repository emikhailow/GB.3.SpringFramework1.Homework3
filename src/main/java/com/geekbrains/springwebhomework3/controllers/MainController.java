package com.geekbrains.springwebhomework3.controllers;

import com.geekbrains.springwebhomework3.repository.ProductsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    private ProductsRepository productsRepository;

    public MainController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @GetMapping("/products")
    public String showProducts(Model model){
        model.addAttribute("products", productsRepository.getProductsList());
        return "products";
    }

    @GetMapping("/products/{id}")
    public String showProduct(Model model, @PathVariable Long id){
        model.addAttribute("product", productsRepository.getByID(id));
        return "product";
    }
}
