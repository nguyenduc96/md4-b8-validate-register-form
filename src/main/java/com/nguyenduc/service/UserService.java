package com.nguyenduc.service;

import com.nguyenduc.model.User;
import com.nguyenduc.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public boolean save(User user) {
        boolean isSave = isSave(user);
        if (isSave) {
            userRepository.save(user);
        }
        return  isSave;
    }

    private boolean isSave(User user) {
        boolean isSave = true;
        List<User> users = findAll();
        for (User user1: users) {
            if (user.getUserName().equals(user1.getUserName())) {
                isSave = false;
                break;
            }
        }
        return isSave;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
