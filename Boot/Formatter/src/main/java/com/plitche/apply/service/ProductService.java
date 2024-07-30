/*
 * (C) 2023 MyCompany
 * All rights reserved.
 */
package com.plitche.apply.service;

import java.util.List;

import com.plitche.apply.dto.Product;

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
