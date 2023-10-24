package com.valentinossobo.demo.model.mapper;

import org.springframework.stereotype.Component;

import com.valentinossobo.demo.model.Product;
import com.valentinossobo.demo.model.dto.ProductDto;

/**
 * @author OSSOBOVALENTIN
 */

@Component
public class ProductMapper {

    public Product toEntity(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.name());
        product.setDescription(productDto.description());
        product.setPrice(productDto.price());
        return product;
    }
    
}
