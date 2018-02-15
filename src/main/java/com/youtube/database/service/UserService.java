package com.youtube.database.service;

import com.youtube.database.model.User;

import java.util.List;

public interface UserService {
    /**
     * Crea o actualiza un registro de usuario en la BD
     * @param user De la clase User
     * @return el usuario guardado
     */

    User save(User user);

    /**
     * Recupera una lista de usuarios
     * @return la lista de usuarios
     */
    List<User> findAll();


    void deleteUser(Long id);
}
