package com.example.demo.service.impl;

import com.example.demo.data.dto.ProductDto;
import com.example.demo.data.entity.Product;
import com.example.demo.data.handler.ProductDataHandler;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    ProductDataHandler productDataHandler;

    @Autowired
    public ProductServiceImpl(ProductDataHandler productDataHandler) {
        this.productDataHandler = productDataHandler;
    }

    @Override
    public ProductDto getProduct(String productId) {
        Product product = productDataHandler.getProductEntity(productId);

        ProductDto productDto = new ProductDto(product.getId(),
                product.getName(), product.getPrice(), product.getStock());

        return productDto;
    }

    @Override
    public ProductDto saveProduct(String productId, String productName, int productPrice, int productStock) {
        Product product = productDataHandler.saveProductEntity(productId, productName, productPrice, productStock);

        ProductDto productDto = new ProductDto(product.getId(),
                product.getName(), product.getPrice(), product.getStock());

        return productDto;
    }

}
