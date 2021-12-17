package ru.chidorirasengan.dao;

import ru.chidorirasengan.entity.Product;

import java.util.List;
/**
 * NetworkTechnologiesProject
 * @author crhaisdeonrgian [https://github.com/Crhaisdeonrgian]
 */
public interface ProductDao {
    public Product findProduct(String code);
    public List<Product> getAllProducts();
    public List<Product> getAllProductsWithCategory(String category);
    public void updateProduct(String code, int quantity);
}
