package com.adminPanel.app.service;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
     void deleteById(int id);
    Product insert(ProductDetails productDetails);
    ProductDetails findById(int id);
    ProductDetails update(ProductDetails productDetails);
    ProductDetails findByProductId(int id);
}
