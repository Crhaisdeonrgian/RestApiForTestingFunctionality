package ru.chidorirasengan.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.chidorirasengan.entity.Order;
import ru.chidorirasengan.entity.ShoppingCart;

public interface ShoppingCartDao {
    public ShoppingCart pushOrder(String code, int quantity, String username);
    public void purchaseCart(String username);
    public void clearCart(String username);
    public ShoppingCart createShoppingCart(String username);
    public ShoppingCart findShoppingCart(String username);

}
