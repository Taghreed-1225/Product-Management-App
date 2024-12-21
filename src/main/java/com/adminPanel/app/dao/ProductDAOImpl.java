package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
@Repository
public class ProductDAOImpl implements ProductDAO{
  @Autowired
    public SessionFactory sessionFactory;
    @Autowired
    public ProductDAO productDAO;

    @Override
    public Product insert(ProductDetails productDetails) {

        try {
            System.out.println("Starting add...");
            System.out.println(productDetails);
            Session session = sessionFactory.getCurrentSession();
            Product product=new Product(productDetails.getName());

            //System.out.println(product.getId());
            System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnn...");
            System.out.println(productDetails.getProductId());
            System.out.println(product);
           // ProductDetails productDetails1=new ProductDetails(productDetails);
            session.persist(product);
            productDetails.setProductId(product.getId());
           // productDetails.setId(product.getId());
            session.persist(productDetails);
          //  session.persist(productDetails1);
            return product;



        }catch (Exception exception)
        {
            System.out.println("catch in insert...");
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        try {
            System.out.println("Starting delete...");
            Session session = sessionFactory.getCurrentSession();
            System.out.println("Starting 2delete...");
            Product product = session.get(Product.class , id);

            System.out.println("Starting 3delete..."+id);
            System.out.println(product);



          // ProductDetails productDetails=session.get(ProductDetails.class , id);
            ProductDetails productDetails=productDAO.findByProductId(id);


            System.out.println(productDetails);
         System.out.println("Starting 4delete...");
            if (productDetails != null) {
                session.delete(productDetails);
            }
            else {
                System.out.println("ProductDetails not found for ID: " + id);
            }
            session.delete(productDetails);
            System.out.println("Starting 5delete...");
            session.delete(product);
            System.out.println("Starting 6delete...");

        }catch (Exception exception)
        {
            System.out.println("catch in delete");
            exception.printStackTrace();
        }

    }


    public List<Product> getAllProducts() {

        try {
            System.out.println("Starting getAllProducts...");
            Session session = sessionFactory.getCurrentSession();
            System.out.println("Session acquired: " + session);
           // session.beginTransaction();
           // System.out.println("Session begin " );
            Query query = session.createQuery("FROM Product");
           // System.out.println("Products fetched: " + productsList);
           // session.getTransaction().commit();
            return (List<Product>) query.list();



        }catch (Exception exception)
        {
            System.out.println("catch in getAll...");
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public ProductDetails findById(int id) {
        try {
            System.out.println("Starting  findById1...");
            Session session = sessionFactory.getCurrentSession();
            System.out.println("Starting  findById2...");
            ProductDetails productDetails=session.get(ProductDetails.class , id);
            System.out.println("Starting find...");

            if (productDetails != null) {
                System.out.println(productDetails);
            }
            else {
                System.out.println("ProductDetails not found for ID: " + id);
            }
            return productDetails;
           // session.delete(productDetails);


        }catch (Exception exception)
        {
            System.out.println("catch in delete");
            exception.printStackTrace();
            return null;
        }

    }

    @Override
    public ProductDetails update(ProductDetails productDetails) {
        try {
            System.out.println("Starting update...");
            System.out.println(productDetails);//done
            Session session = sessionFactory.getCurrentSession();
            System.out.println("Starting update2...");
            int id= productDetails.getId();
            System.out.println("Starting update3..."+id);
            ProductDetails productDetails1 = session.get(ProductDetails.class , id);
            System.out.println("Starting update4..."+productDetails1);
          productDetails1.set(productDetails);
            System.out.println("Starting update5...");
            System.out.println(productDetails);
            System.out.println("Starting update6...");
            Product product=new Product();
            System.out.println("Starting update7...");
            int Pid=productDetails.getProductId();
            System.out.println(Pid);
            product = session.get(Product.class , Pid);
            System.out.println("Starting update8...");
            System.out.println(product);
            product.setName(productDetails.getName());
            System.out.println("Starting update9...");

           // session.persist(product);
            session.persist(productDetails1);
            System.out.println("Starting update10...");
            return productDetails1;



        }catch (Exception exception)
        {
            System.out.println("catch from update in dao...");
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public ProductDetails findByProductId(int t) {
        try {
            System.out.println("Starting  findByProductId1...");
            Session session = sessionFactory.getCurrentSession();
            System.out.println("Starting  findByProductId2...");

            String hql = "FROM ProductDetails  WHERE productId = :t";
            System.out.println("Starting  findByProductId3...");
            Query<ProductDetails> query = session.createQuery(hql, ProductDetails.class);
            System.out.println("Starting  findByProductId4...");
            query.setParameter("t",t);
            System.out.println("Starting  findByProductId5..."+t);
            ProductDetails productDetails = (ProductDetails) query.uniqueResult();
            System.out.println("qyery..."+query);
            System.out.println("qyery..."+productDetails);
          return productDetails;

        }catch (Exception exception)
        {
            System.out.println("catch in findByProductId");
            exception.printStackTrace();
            return null;
        }

    }

}
