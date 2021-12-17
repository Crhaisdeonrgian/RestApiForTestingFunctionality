package ru.chidorirasengan.dao;

import ru.chidorirasengan.entity.Order;
/**
 * NetworkTechnologiesProject
 * @author crhaisdeonrgian [https://github.com/Crhaisdeonrgian]
 */
public interface OrderDao {
    public Order saveOrder(String code, int quantity, String username);
}
