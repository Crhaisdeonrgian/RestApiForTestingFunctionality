package ru.chidorirasengan.dao;


import ru.chidorirasengan.entity.User;

public interface UserDetailsDao {
    User findUserByUsername(String username);
}
