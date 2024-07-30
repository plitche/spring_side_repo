package com.plitche.notApply.service.impl;

import com.plitche.apply.dto.Product;
import com.plitche.notApply.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {

    private static List<Product> productList = new ArrayList<>();

    @Override
    public void addProduct(Long id, String name, int price, int stock, String serialNo, String description) {
        Product product = Product.builder()
                .id(id).name(name).price(price).stock(stock).serialNo(serialNo).description(description)
                .build();

        productList.add(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productList;
    }

    @Override
    public List<Product> getProductByName(String name) {
        return productList.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public Product getProductById(Long id) {
        return productList.stream().filter(p -> p.getId() == id).findFirst().get();
    }

    @Override
    public void deleteProductByName(String name) {
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName() == name) {
                iterator.remove();
            }
        }
    }

    @Override
    public void deleteProductById(Long id) {
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId() == id) {
                iterator.remove();
            }
        }
    }

    @Override
    public int getTotalPrice() {
        return productList.stream().map(Product::getPrice).reduce(0, Integer::sum);
    }

    @Override
    public int getTotalStock() {
        return productList.stream().map(Product::getStock).reduce(0, Integer::sum);
    }
}
