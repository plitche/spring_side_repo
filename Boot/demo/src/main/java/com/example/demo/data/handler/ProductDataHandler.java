package com.example.demo.data.handler;

import com.example.demo.data.entity.Product;

public interface ProductDataHandler {

    Product getProductEntity(String productId);

    Product saveProductEntity(String productId, String productName, int productPrice, int productStock);
}
