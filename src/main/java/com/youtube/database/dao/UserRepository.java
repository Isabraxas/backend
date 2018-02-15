package com.youtube.database.dao;

import com.youtube.database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User save(User user);

    //No necesito el metodo ya que el objeto en UserServiceImpl tambien extiende de JpaRepository
   // List<User> findAll();
    //User findByFirstName(String firstName);
    //List<User> findByFirstNameContaining(String firstName);
    List<User> findByFirstNameContainingOrSecondNameContaining(String firstName, String secondName);
}
