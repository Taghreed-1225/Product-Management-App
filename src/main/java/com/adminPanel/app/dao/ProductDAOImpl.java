package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
@Repository
public class ProductDAOImpl implements ProductDAO{
  @Autowired
    public SessionFactory sessionFactory;
    @Autowired
    public ProductDAO productDAO;

    @Override
    public ProductDetails insert(ProductDetails productDetails) {

        try {
            System.out.println("Starting add...");
            System.out.println(productDetails);
            Session session = sessionFactory.getCurrentSession();
           Product product=new Product(productDetails.getName());
           product.setProductDetailsId(productDetails);
            //System.out.println(product.getId());
            System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnn...");
           // System.out.println(productDetails.getProductId());
            //System.out.println(product);
           // ProductDetails productDetails1=new ProductDetails(productDetails);
            session.persist(product);
           // productDetails.setProductId(product.getId());
           // productDetails.setId(product.getId());
           // session.persist(productDetails);
          //  session.persist(productDetails1);

            return productDetails;



        }catch (Exception exception)
        {
            System.out.println("catch in insert...");
            exception.printStackTrace();
        }
        return null;
  }


    @Override
    public Product findById(int id) {
        try {

            Session session = sessionFactory.getCurrentSession();
            return session.get(Product.class,id);

        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }




    @Override
    public void update(ProductDetails newProduct) {
        try {
            System.out.println("hello from update in dao");
            Session session = sessionFactory.getCurrentSession();

            System.out.println(newProduct.getName()+newProduct.getId()+newProduct.getManufacturer());
            //the old and new id will be the same but different data
            ProductDetails oldProductDetails = session.get(ProductDetails.class , newProduct.getId());
            System.out.println(oldProductDetails.getName()+oldProductDetails.getId()+oldProductDetails.getManufacturer());
            Product oldProduct = oldProductDetails.getProduct();
            System.out.println(oldProduct);

            //set the values with new values
            oldProduct.setName(newProduct.getName());
            oldProductDetails.setName(newProduct.getName());
            oldProductDetails.setExpirationDate(newProduct.getExpirationDate());
            oldProductDetails.setManufacturer(newProduct.getManufacturer());
            oldProductDetails.setPrice(newProduct.getPrice());
            oldProductDetails.setAvailable(newProduct.isAvailable());
            oldProductDetails.setProduct(newProduct.getProduct());

            //we will set the oldProductDetails after update to the oldProduct and the oldProduct will be updated too
           //oldProduct.setProductDetails(oldProductDetails);
            System.out.println(oldProduct);
            session.update(oldProduct);
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
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



//          // ProductDetails productDetails=session.get(ProductDetails.class , id);
//            ProductDetails productDetails=productDAO.findByProductId(id);
//
//
//            System.out.println(productDetails);
//         System.out.println("Starting 4delete...");
//            if (productDetails != null) {
//                session.delete(productDetails);
//            }
//            else {
//                System.out.println("ProductDetails not found for ID: " + id);
//            }
//            session.delete(productDetails);
//            System.out.println("Starting 5delete...");
            session.delete(product);
//            System.out.println("Starting 6delete...");
//
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
            System.out.println("qqqq");
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

//    @Override
//    public Product findById(int pid) {
//        try {
//            System.out.println("Starting  findById1...");
//            Session session = sessionFactory.getCurrentSession();
//            System.out.println("Starting  findById2...");
//
//            String hql = "FROM Product  WHERE productDetailsId  = :pid";
//            System.out.println("Starting  findByProductId3...");
//            Query<Product> query = session.createQuery(hql, Product.class);
//            System.out.println("Starting  findByProductId4...");
//            query.setParameter("pid",pid);
//
//
//
//            System.out.println("Starting find...");
//            System.out.println(pid);
//            Product product = (Product) query.uniqueResult();
//            System.out.println(product);
//
//            return product;
//           // session.delete(productDetails);
//
//
//        }catch (Exception exception)
//        {
//            System.out.println("catch in find");
//            exception.printStackTrace();
//            return null;
//        }
//
//    }

//    @Override
//    public ProductDetails update(ProductDetails productDetails) {
//        try {
//
//            System.out.println("Starting update...");
//            System.out.println(productDetails);//done
//
//            Session session = sessionFactory.getCurrentSession();
//            System.out.println("Starting update2...");
//
//            int id= productDetails.getId();
//            System.out.println("Starting update3..."+id);
//            ProductDetails productDetails1 = session.get(ProductDetails.class , id);
//            System.out.println("Starting update4..."+productDetails1);
//
//
//
//          productDetails1.set(productDetails);
//            System.out.println("Starting update5...");
//            System.out.println(productDetails);
//            System.out.println("Starting update6...");
//
//
//
//          Product oldProduct=productDAO.findById(id);
//           System.out.println(oldProduct);
//           oldProduct.setProductDetailsId(productDetails1);
////            int Pid=productDetails.getProductId();
////            System.out.println(Pid);
////            product = session.get(Product.class , Pid);
////            System.out.println("Starting update8...");
////            System.out.println(product);
////            product.setName(productDetails.getName());
////            System.out.println("Starting update9...");
//
//           // session.persist(product);
//            session.update(oldProduct);
//            System.out.println("Starting update10...");
//            return productDetails1;
//
//
//
//        }catch (Exception exception)
//        {
//            System.out.println("catch from update in dao...");
//            exception.printStackTrace();
//            return null;
//        }
//
//    }



    @Override
    public ProductDetails findByProductId(int t) {
        try {
            System.out.println("Starting  findByProductId1...");
            Session session = sessionFactory.getCurrentSession();
            System.out.println("Starting  findByProductId2...");
            Product product = session.get(Product.class , t);
            System.out.println(product);
            int i= product.getProductDetailsId().getId();
            System.out.println(i);
            String hql = "FROM ProductDetails  WHERE id = :i";
           System.out.println("Starting  findByProductId3...");
            Query<ProductDetails> query = session.createQuery(hql, ProductDetails.class);
            System.out.println("Starting  findByProductId4...");
           query.setParameter("i",i);
            System.out.println("Starting  findByProductId5..."+i);
           ProductDetails productDetails = (ProductDetails) query.uniqueResult();
            System.out.println("qyery..."+query);
            System.out.println("qyery..."+productDetails.getName()+productDetails.getId()+productDetails.getManufacturer());
          return productDetails;
       }catch (Exception exception)
       {
         System.out.println("catch in findByProductId");
            exception.printStackTrace();
            return null;
       }

    }


    public List<Product> findByName(String c) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where name=:productName");
        query.setParameter("productName" , c);
        System.out.println("hello from search dao ");
        System.out.println(query.list());
        return query.list();


    }

}
