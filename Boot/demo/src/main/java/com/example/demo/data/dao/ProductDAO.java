package com.example.demo.data.dao;

import com.example.demo.data.entity.Product;

public interface ProductDAO {

    Product saveProduct(Product product);

    Product getProduct(String productId);

}
