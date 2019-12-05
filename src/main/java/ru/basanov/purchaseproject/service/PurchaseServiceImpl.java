package ru.basanov.purchaseproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.basanov.purchaseproject.domain.Purchase;
import ru.basanov.purchaseproject.domain.User;
import ru.basanov.purchaseproject.repository.PurchaseRepository;
import ru.basanov.purchaseproject.repository.UserRepository;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private PurchaseRepository purchaseRepository;

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setPurchaseRepository(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public Purchase findPurchaseById(Long id) {
        return purchaseRepository.findPurchaseById(id);
    }

    @Override
    public Purchase buildPurchase(String name, String userId) {

        User user = userRepository.findById(Long.parseLong(userId)).orElse(null);

        Purchase newPurchase = new Purchase();
        newPurchase.setName(name);
        newPurchase.setUser(user);
        return newPurchase;
    }

    @Override
    public Page<Purchase> getPurchaseWithPaging(int pageNumber, int pageSize) {
        return purchaseRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    @Override
    public Iterable<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    @Override
    public List<Purchase> findAllPurchasesByUser(User user) {
        return purchaseRepository.findAllByUser(user);
    }

    @Override
    public Purchase saveOrUpdate(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    @Override
    public void delete(Long purchaseId) {
        purchaseRepository.deleteById(purchaseId);
    }
}
