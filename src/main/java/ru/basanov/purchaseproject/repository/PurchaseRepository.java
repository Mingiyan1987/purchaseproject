package ru.basanov.purchaseproject.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.basanov.purchaseproject.domain.Purchase;
import ru.basanov.purchaseproject.domain.User;

import java.util.List;

@Repository
public interface PurchaseRepository extends PagingAndSortingRepository<Purchase, Long> {
    Purchase findPurchaseById(Long id);

    List<Purchase> findAllByUser(User user);

}
