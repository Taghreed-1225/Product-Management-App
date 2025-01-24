package com.adminPanel.app.model;




import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@javax.persistence.Table(name = "product")
@Setter
@Getter
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @NotEmpty(message = "cannot empty")
    @Column(name="name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
   @JoinColumn(name="product_details_id")
    private ProductDetails productDetailsId;


//@JsonIgnore
//@OneToOne(cascade = CascadeType.ALL  )
//@JoinColumn(name = "product_details_id")
//private ProductDetails productDetails;productDetails

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productDetailsId=" + productDetailsId +
                '}';
    }
}
