package com.example.demo.data.repository;

import com.example.demo.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

}
