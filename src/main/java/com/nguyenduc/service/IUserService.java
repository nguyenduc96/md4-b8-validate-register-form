package com.nguyenduc.service;

import com.nguyenduc.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(Long id);

    boolean save(User user);

    void  delete(Long id);

    Page<User> findAll(Pageable pageable);
}
