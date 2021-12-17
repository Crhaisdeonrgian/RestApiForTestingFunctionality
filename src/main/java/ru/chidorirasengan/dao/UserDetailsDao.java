package ru.chidorirasengan.dao;


import ru.chidorirasengan.entity.User;
/**
 * NetworkTechnologiesProject
 * @author crhaisdeonrgian [https://github.com/Crhaisdeonrgian]
 */
public interface UserDetailsDao {
    User findUserByUsername(String username);
    User saveUser(User user);
}
