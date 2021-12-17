package ru.chidorirasengan.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.chidorirasengan.entity.Order;
import ru.chidorirasengan.entity.Product;
import ru.chidorirasengan.entity.ShoppingCart;
import ru.chidorirasengan.entity.User;

import java.util.HashSet;
import java.util.Set;
/**
 * NetworkTechnologiesProject
 * @author crhaisdeonrgian [https://github.com/Crhaisdeonrgian]
 */
@Transactional
@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private UserDetailsDao userDetailsDao;
    @Autowired
    private OrderDao orderDao;

    @Override
    public ShoppingCart findShoppingCart(String username) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(ShoppingCart.class,username);
    }

    @Override
    public ShoppingCart createShoppingCart(String username){
        Session session = sessionFactory.getCurrentSession();
        if(session.get(ShoppingCart.class,username)==null) {

            User user = userDetailsDao.findUserByUsername(username);
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setCart_id(username);
            shoppingCart.setSum(0);
            session.save(shoppingCart);
            Set<Order> orders = new HashSet<>();
            shoppingCart.setOrders(orders);
            return shoppingCart;
        }
        return session.get(ShoppingCart.class,username);
    }
    public ShoppingCart pushOrder(String code, int quantity, String username) {
        Session session = sessionFactory.getCurrentSession();
        Order order = orderDao.saveOrder(code, quantity, username);
        ShoppingCart shoppingCart = findShoppingCart(username);
        Set<Order> updateOrders = shoppingCart.getOrders();
        updateOrders.add(order);
        shoppingCart.setOrders(updateOrders);
        shoppingCart.setSum(shoppingCart.getSum()+order.getAmount());
        session.update(shoppingCart);
        return shoppingCart;
    }

    @Override
    public void purchaseCart(String username) {
        Session session = sessionFactory.getCurrentSession();
        ShoppingCart shoppingCart = findShoppingCart(username);
        Set<Order> orders = shoppingCart.getOrders();
        Product product;
        for (Order order: orders){
            product = order.getProduct();
            session.delete(order);
        }
        shoppingCart.setOrders(new HashSet<>());
        shoppingCart.setSum(0);
    }

    @Override
    public void clearCart(String username) {
        Session session = sessionFactory.getCurrentSession();
        ShoppingCart shoppingCart =findShoppingCart(username);
        Set<Order> orders = shoppingCart.getOrders();
        Product product;
        for (Order order: orders){
            product = order.getProduct();
            product.setQuantity(product.getQuantity()+order.getQuantity());
            session.delete(order);
        }
        shoppingCart.setOrders(new HashSet<>());
        shoppingCart.setSum(0);
    }

}
