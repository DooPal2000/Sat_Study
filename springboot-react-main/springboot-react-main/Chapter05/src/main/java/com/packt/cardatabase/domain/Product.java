package com.packt.cardatabase.domain;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String explanation;

    private int price;

    public Product() {
    }

    public Product(String id, String name, String explanation, int price) {
        super();
        this.id = id;
        this.name = name;
        this.explanation = explanation;
        this.price = price;
    }


}
