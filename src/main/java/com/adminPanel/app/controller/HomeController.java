package com.adminPanel.app.controller;

import com.adminPanel.app.dao.ProductDAO;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import com.adminPanel.app.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController
{
 @Autowired
 private ProductService productService;

    @RequestMapping("/")
    public String homePage(Model productModel)throws ParseException
    {
       // List<Product> productList = productService.getAllProducts();
       List<Product> productList = productService.getAllProducts();
        productModel.addAttribute("productList" , productList);
        System.out.println("hellooooooooooooooooooooo");
        System.out.println(productList);
      // model.addAttribute("product",new Product());// send object
     if (productList.isEmpty()) {
      productModel.addAttribute("productDetails", new ProductDetails());
     }
        System.out.println(productModel);
        return "homePage";
    }

 @RequestMapping("/deleteProduct")
 public String deleteProduct( @RequestParam("Id") int theId)
 {
  productService.deleteById(theId);



  return "redirect:/";
 }

 @RequestMapping("/addProduct")
 public String addProduct(Model model)
 {
  System.out.println(model);
  System.out.println("hello from add product");
  model.addAttribute("productDetails",new ProductDetails());// send object
  System.out.println("hello222 from add product");
  System.out.println(model);

  return "AddProductForm";
 }

 @RequestMapping("/form")
 public String form(@Valid @ModelAttribute("productDetails")  ProductDetails productDetails, BindingResult bindingResult, Model model)
 {System.out.println(bindingResult.hasErrors());
  if(bindingResult.hasErrors()){

   System.out.println(bindingResult.hasErrors());
   return "AddProductForm";
  }
  System.out.println("hello from from");

  productService.insert(productDetails);
  System.out.println(productDetails);
 // return "homePage";
  return "redirect:/";
 }

 @RequestMapping("/showProduct")
 public String showProduct( @RequestParam("productId") int id,Model model)
 {
  System.out.println("hello from show");
  System.out.println(id);
  ProductDetails productDetails=new ProductDetails();
  productDetails=productService.findByProductId(id);
  model.addAttribute("productDetails",  productDetails);



  return "showPage";
 }

 @RequestMapping("/updateProduct")

 public String updateProduct(@ModelAttribute("productId")  int productId, Model model)
 {
 System.out.println(productId);//done
  System.out.println("hello from update controller1");
  ProductDetails productDetails =productService.findByProductId(productId);

  model.addAttribute("productDetails",  productDetails);
  System.out.println("end of controller update  .. "+productDetails.getName()+productDetails.getId()+productDetails.getManufacturer());


  return "updatePage";
 }

 @RequestMapping("/test")

 public String testProduct(@ModelAttribute("productDetails")  ProductDetails productDetails, Model model)
 {
   System.out.println(productDetails);//done
  System.out.println("hello from test controller1");
  model.addAttribute("productDetails", new ProductDetails());
   productService.update(productDetails);
  System.out.println("hello from  end test controller1");


  return "redirect:/";
 }
 @GetMapping("/apiTest")
 //@ResponseBody
 public String testAPi()
 {
  return "HelloFromJSON";
 }

 //this initBinder will be used to format the date from the backend to the frontend to show
 // the expiration date in update form by this format dd/mm/yyyy
// @InitBinder
// public void initBinder(WebDataBinder binder) {
//  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//  binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
// }

 @GetMapping("/searchProduct")
 public String searchProducts(@RequestParam("searchKey") String searchKey , Model productModel)
 {
  System.out.println("hello from search");
  System.out.println(searchKey);
  List<Product> productList = productService.findByName(searchKey);
  productModel.addAttribute("productList" , productList);
  System.out.println("list = "+productList);
  return "homePage";
 }

}
