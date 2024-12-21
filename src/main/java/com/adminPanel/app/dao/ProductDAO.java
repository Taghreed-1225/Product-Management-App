package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;

import java.util.List;

public interface ProductDAO {
    Product insert(ProductDetails productDetails);
    void deleteById(int id);
    public List<Product> getAllProducts();
    ProductDetails findById(int id);
    ProductDetails update(ProductDetails productDetails);
    ProductDetails findByProductId(int id);
}
