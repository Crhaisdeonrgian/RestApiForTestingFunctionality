package ru.chidorirasengan.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.chidorirasengan.entity.Order;
import ru.chidorirasengan.entity.Product;
import ru.chidorirasengan.entity.User;
@Transactional
@Repository
public class OrderDaoImpl implements OrderDao{
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private UserDetailsDao userDetailsDao;
    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Override
    public Order saveOrder(String code, int quantity, String username) {
        Session session = sessionFactory.getCurrentSession();
        User user = userDetailsDao.findUserByUsername(username);
        Product product = productDao.findProduct(code);
        product.setQuantity(product.getQuantity()-quantity);
        Order order = new Order();
        order.setProduct(product);
        order.setAmount(quantity*(product.getPrice()));
        order.setQuantity(quantity);
        order.setUser(user);
        order.setShoppingCart(shoppingCartDao.findShoppingCart(username));
        session.save(order);
        return order;

    }
}
