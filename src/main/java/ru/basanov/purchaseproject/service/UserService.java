package ru.basanov.purchaseproject.service;

import ru.basanov.purchaseproject.domain.User;

public interface UserService {

    Iterable<User> findAll();

    User findById(Long id);
}
