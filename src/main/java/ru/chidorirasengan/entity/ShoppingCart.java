package ru.chidorirasengan.entity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
/**
 * NetworkTechnologiesProject
 * @author crhaisdeonrgian [https://github.com/Crhaisdeonrgian]
 */
@Entity
@Table(name = "Cart")
public class ShoppingCart implements Serializable{
    @Id
    @Column(name = "cart_id", length = 255, nullable = false)
    private String cart_id;
    @Column(name = "Sum", nullable = false)
    private double sum;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "shoppingCart")
    /*@JoinColumn(name = "ID", nullable = false, //
            foreignKey = @ForeignKey(name = "Order_in_cart_FK"))*/
    private Set<Order> orders = new HashSet<>();

    public ShoppingCart(){}

    public String getCart_id() {
        return cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }


    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

}