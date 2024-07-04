package com.example.demo.service;

import com.example.demo.data.dto.ProductDto;

public interface ProductService {

    ProductDto getProduct(String productId);

    ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);

}
