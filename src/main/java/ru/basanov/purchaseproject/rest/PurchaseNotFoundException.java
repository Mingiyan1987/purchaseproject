package ru.basanov.purchaseproject.rest;

public class PurchaseNotFoundException extends RuntimeException {
    public PurchaseNotFoundException(String message) {
        super(message);
    }
}
