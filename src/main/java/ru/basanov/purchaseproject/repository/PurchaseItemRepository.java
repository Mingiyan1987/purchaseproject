package ru.basanov.purchaseproject.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.basanov.purchaseproject.domain.PurchaseItem;


@Repository
public interface PurchaseItemRepository extends PagingAndSortingRepository<PurchaseItem, Long> {
}
