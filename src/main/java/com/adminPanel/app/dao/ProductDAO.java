package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;

import java.util.List;

public interface ProductDAO {
    ProductDetails insert(ProductDetails productDetails);
    void deleteById(int id);
    public List<Product> getAllProducts();


    Product findById(int pid);

    void update(ProductDetails productDetails);
    ProductDetails findByProductId(int id);
    List<Product>findByName(String c);
}
