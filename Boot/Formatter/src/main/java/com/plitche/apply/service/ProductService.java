package com.plitche.apply.service;

import com.plitche.apply.dto.Product;

import java.util.List;

public interface ProductService {

    void addProduct(Long id, String name, int price, int stock, String serialNo, String description);

    List<Product> getAllProduct();

    List<Product> getProductByName(String name);

    Product getProductById(Long id);

    void deleteProductByName(String name);

    void deleteProductById(Long id);

    int getTotalPrice();

    int getTotalStock();
}
