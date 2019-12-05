package ru.basanov.purchaseproject.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.basanov.purchaseproject.domain.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByName(String name);
}
