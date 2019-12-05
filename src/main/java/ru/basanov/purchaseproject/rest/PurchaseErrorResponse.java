package ru.basanov.purchaseproject.rest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PurchaseErrorResponse {
    private int status;
    private String message;
    private long timestamp;


}
