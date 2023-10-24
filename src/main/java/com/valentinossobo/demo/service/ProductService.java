package com.valentinossobo.demo.service;

import java.util.List;

import com.valentinossobo.demo.model.Product;
import com.valentinossobo.demo.model.dto.ProductDto;

/**
 * @author OSSOBOVALENTIN
 */
public interface ProductService {

    Product create(ProductDto productDto);
    List<Product> index();
    Product  find(Long id);
    Product update(ProductDto productDto, Long id);
    String delete(Long id);
    
}
