package com.sda.hibernate.dao;

import java.util.List;

public interface UserDao {

    // CRUD

    // command vs query

    void create(User user);

    List<User> findAll();

    User findById(Long id);

    void update(Long id, User userData);

    void delete(Long id);

    void deleteAll();
}
