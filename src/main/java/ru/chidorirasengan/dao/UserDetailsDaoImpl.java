package ru.chidorirasengan.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.chidorirasengan.entity.Order;
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
public class UserDetailsDaoImpl implements UserDetailsDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findUserByUsername(String username) {
        return sessionFactory.getCurrentSession().get(User.class, username);
    }

    @Override
    public User saveUser(User user) {

        Session session = sessionFactory.getCurrentSession();
        if(session.get(User.class, user.getUsername())==null) {
            session.save(user);
            user.setEnabled(true);
            return user;
        }
        return session.get(User.class,user.getUsername());
    }
}
