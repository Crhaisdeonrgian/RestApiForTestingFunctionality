package ru.chidorirasengan.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.chidorirasengan.entity.Product;
import ru.chidorirasengan.entity.User;

import java.util.List;
@Transactional
@Repository
public class ProductDaoImpl implements ProductDao{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Product findProduct(String code){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, code);
    }
    @Override
    public List<Product> getAllProducts(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Product p", Product.class)
                .getResultList();

    }

    @Override
    public List<Product> getAllProductsWithCategory(String category) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Product p where p.category=:category", Product.class)
                .setParameter("category",category)
                .getResultList();
    }

    @Override
    public void updateProduct(String code, int quantity) {
        findProduct(code).setQuantity(quantity);
    }
}
