package ru.chidorirasengan.dao;

import ru.chidorirasengan.entity.Order;

public interface OrderDao {
    public Order saveOrder(String code, int quantity, String username);
}
