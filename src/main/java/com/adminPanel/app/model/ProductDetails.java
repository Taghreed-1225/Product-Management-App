package com.adminPanel.app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Table;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@javax.persistence.Table(name="product_details")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class ProductDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @NotEmpty(message = "cannot empty")
    @Column(name="name")
    private String name;

    @NotNull(message = "is required")
    @Positive(message = "Price must be a positive number")
    @Column(name="price")
     private double price;

    @NotNull(message = "is required")
    @Column(name="available")
    private boolean available;

    @NotEmpty(message = "cannot empty")
    @Column(name="manufacturer")
    private String manufacturer;


    @NotNull(message = "is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name="expiration_date")
    private Date expirationDate;

    //@OneToOne(cascade = CascadeType.ALL)
  //  @JoinColumn(name="product_id")
    @Column(name="product_id")
    private int productId;

    public void set(ProductDetails productDetails)
    {
        System.out.println("hello from set ");
        System.out.println(productDetails);
        this.name=productDetails.name;
        this.manufacturer=productDetails.manufacturer;
        this.price=productDetails.price;
        this.available=productDetails.available;
        this.expirationDate=productDetails.expirationDate;


    }
}
