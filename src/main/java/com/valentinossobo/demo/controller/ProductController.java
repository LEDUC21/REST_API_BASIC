package com.valentinossobo.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valentinossobo.demo.model.Product;
import com.valentinossobo.demo.model.dto.ProductDto;
import com.valentinossobo.demo.service.ProductService;

import lombok.AllArgsConstructor;
import java.util.List;

/**
 *  @author OSSOBO_VALENTIN
 */
@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public Product create(@RequestBody ProductDto productDto) {
        return productService.create(productDto);
    }
    
    @GetMapping("/index")
    public List<Product> index() {
        return productService.index();
    }

    @GetMapping("/find/{id}")
    public Product find(@PathVariable Long id) {
        return productService.find(id);
    }

    @PutMapping("/update/{id}")
    public Product update(@RequestBody ProductDto productDto, @PathVariable Long id) {
        return productService.update(productDto, id);
    
    }

    @DeleteMapping("/delete/{id}") 
    public String delete(@PathVariable Long id) {
        return productService.delete(id);
    }
}
