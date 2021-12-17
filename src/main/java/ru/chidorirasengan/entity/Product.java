package ru.chidorirasengan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * NetworkTechnologiesProject
 * @author crhaisdeonrgian [https://github.com/Crhaisdeonrgian]
 */
@Entity
@Table(name = "Products")
public class Product implements Serializable {
    private String code;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String category;

    public Product() {
    }
    @Id
    @Column(name = "Code", length = 20, nullable = false)
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "Name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "Description", length = 1023)
    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}

    @Column(name = "Category", nullable = false)
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    @Column(name = "Price", nullable = false)
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name = "Quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}