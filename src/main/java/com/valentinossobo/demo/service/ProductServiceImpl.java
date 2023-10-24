package com.valentinossobo.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.valentinossobo.demo.model.Product;
import com.valentinossobo.demo.model.dto.ProductDto;
import com.valentinossobo.demo.model.mapper.ProductMapper;
import com.valentinossobo.demo.repository.ProductRepository;

import lombok.AllArgsConstructor;

/**
 * @author OSSOBOVALENTIN
 */

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Product create(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        product = productRepository.save(product);
        return product;
    }

    @Override
    public String delete(Long id) {
        if (productRepository.findById(id).isPresent()) {            
            productRepository.deleteById(id);
            return "the product deleted successfuly";
        } else {
            return "Invalid Product";
        }
    
    }

    @Override
    public Product find(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> index() {
        return productRepository.findAll();
    }

    @Override
    public Product update(ProductDto productDto, Long id) {
        return productRepository.findById(id)
                 .map(p-> {
                     p.setPrice(productDto.price());
                     p.setDescription(productDto.description());
                     p.setName(productDto.name());
                     return productRepository.save(p);
                 }).orElseThrow(() -> new RuntimeException("Product does not exist"));
     }
    
}
