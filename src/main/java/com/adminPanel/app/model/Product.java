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
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @NotEmpty(message = "cannot empty")
    @Column(name="name")
    private String name;

//    @OneToOne
//    @JoinColumn(name="product_details_id")
//    private ProductDetails productDetailsId;

    public Product(String name) {
        this.name = name;
    }
}
