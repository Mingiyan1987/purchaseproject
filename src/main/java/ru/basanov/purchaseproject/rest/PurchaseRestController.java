package ru.basanov.purchaseproject.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.basanov.purchaseproject.domain.Purchase;
import ru.basanov.purchaseproject.service.PurchaseService;
import ru.basanov.purchaseproject.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api")
public class PurchaseRestController {

    private static final int INITIAL_PAGE = 0;
    private static final int PAGE_SIZE = 100;

    private PurchaseService purchaseservice;

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setPurchaseservice(PurchaseService purchaseservice) {
        this.purchaseservice = purchaseservice;
    }

    @GetMapping(value = "/purchases", produces = "application/xml")
    public Iterable<Purchase> getAllPurchases() {
        return purchaseservice.findAll();
    }

    @GetMapping(value = "/{id}/purchases", produces = "application/xml")
    public List<Purchase> getCustomerPurchase(@PathVariable("id") Long id) {
        return purchaseservice.findAllPurchasesByUser(userService.findById(id));
    }

    @GetMapping("{/purchases/{id}")
    public ResponseEntity<?> getPurchaseById(@PathVariable("id") Long id) {
        Purchase purchase = purchaseservice.findPurchaseById(id);
        return new ResponseEntity<>(purchase, HttpStatus.OK);
    }

    @PostMapping("/purchases")
    public Purchase addPurchase(@RequestBody Purchase purchase) {
        purchase.setId(0L);
        purchase = purchaseservice.saveOrUpdate(purchase);
        return purchase;
    }

    @PutMapping(path = "/purchases", consumes = {"application/xml"},
            produces = "application/xml")
    public Purchase updatePurchase(@RequestBody Purchase purchase) {
        purchase = purchaseservice.saveOrUpdate(purchase);
        return purchase;
    }

    @DeleteMapping("/purchases/{purchaseId}")
    public int deletePurchase(@PathVariable Long purchaseId) {
        purchaseservice.delete(purchaseId);
        return HttpStatus.OK.value();
    }

    @ExceptionHandler
    public ResponseEntity<PurchaseErrorResponse> handleException(PurchaseNotFoundException exc) {
        PurchaseErrorResponse purchaseErrorResponse = new PurchaseErrorResponse();
        purchaseErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        purchaseErrorResponse.setMessage(exc.getMessage());
        purchaseErrorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(purchaseErrorResponse, HttpStatus.NOT_FOUND);
    }
}
