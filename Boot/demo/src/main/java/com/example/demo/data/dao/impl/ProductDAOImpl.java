package com.example.demo.data.dao.impl;

import com.example.demo.data.dao.ProductDAO;
import com.example.demo.data.entity.Product;
import com.example.demo.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAOImpl implements ProductDAO {

    ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public Product getProduct(String productId) {
        Product product = productRepository.getById(productId);
        return product;
    }
}
