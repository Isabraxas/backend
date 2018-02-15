package com.youtube.database.service;

import com.youtube.database.dao.UserRepository;
import com.youtube.database.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    protected UserRepository userRepository;

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        this.userRepository.delete(id);
    }

    @Override
    public void deleteUserById(Long id) {
        this.userRepository.delete(id);

    }

    @Override
    public List<User> findByName(String name) {
       //return this.userRepository.findByFirstName(name);
        return this.userRepository.findByFirstNameContainingOrSecondNameContaining(name,name);
    }


}
