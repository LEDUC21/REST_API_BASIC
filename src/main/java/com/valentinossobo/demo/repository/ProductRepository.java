package com.valentinossobo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valentinossobo.demo.model.Product;

/**
 * @author OSSOBOVALENTIN
 */

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
