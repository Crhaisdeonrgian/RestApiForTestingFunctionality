/*
package ru.chidorirasengan.entity;
  NetworkTechnologiesProject
  @author crhaisdeonrgian [https://github.com/Crhaisdeonrgian]

import javax.persistence.*;
import java.util.HashSet;

@Entity
@Table(name = "Categories",
        uniqueConstraints = { @UniqueConstraint(columnNames = {"ID","Product_id"}) })
public class Category {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "Name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "name")
    @JoinColumn(name = "Username", nullable = false,
             foreignKey = @ForeignKey(name = "Cat_product_FK")
            private Set<Products> products = new HashSet<>();

}
*/
