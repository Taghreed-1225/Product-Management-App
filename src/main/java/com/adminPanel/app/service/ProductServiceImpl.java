package com.adminPanel.app.service;

import com.adminPanel.app.dao.ProductDAO;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import java.util.Collections;
import java.util.List;
//@Component
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO productDAO;

    @Transactional
    @Override
    public List<Product> getAllProducts() {
        try {

            return productDAO.getAllProducts();
        }catch (Exception exception)
        {
            System.out.println("hello from catch in service");
            exception.printStackTrace();
        }
        return null;
    }
    @Transactional
    @Override
    public void deleteById(int id) {
        try {
            System.out.println("hello from try in  delete service");
            productDAO.deleteById(id);
            System.out.println("hello from try in  after delete service");
        }catch (Exception exception)
        {
            System.out.println("hello from catch in  delete service");
            exception.printStackTrace();
        }


    }
    @Transactional
    @Override
    public Product insert(ProductDetails productDetails) {
        try {
            System.out.println("hello from try in service");
            return productDAO.insert(productDetails);
        }catch (Exception exception)
        {
            System.out.println("hello from catch in service");
            exception.printStackTrace();
        }
        return null;
    }
    @Transactional
    @Override
    public ProductDetails findById(int id) {
        try {
            System.out.println("hello from try in  findById service");
            return productDAO.findById(id);

        }catch (Exception exception)
        {
            System.out.println("hello from catch in findById service");
            exception.printStackTrace();
        }
        return null;
    }
    @Transactional
    @Override
    public ProductDetails update(ProductDetails productDetails) {
        try {
            System.out.println("hello from update in service");
            System.out.println(productDetails);//done
            return productDAO.update(productDetails);
        }catch (Exception exception)
        {
            System.out.println("hello from catch update in service");
            exception.printStackTrace();
        }
        return null;
    }


    @Transactional
    @Override
    public ProductDetails findByProductId(int id) {
        try {
            System.out.println("hello from try in  findByProductId service");
            return productDAO.findByProductId(id);

        }catch (Exception exception)
        {
            System.out.println("hello from catch in findByProductId service");
            exception.printStackTrace();
        }
        return null;
    }
}
