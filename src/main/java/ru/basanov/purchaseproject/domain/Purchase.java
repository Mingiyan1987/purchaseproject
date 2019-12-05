package ru.basanov.purchaseproject.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "purchase")
@Data
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "purchase_item_join",
            joinColumns = @JoinColumn(name = "purchase_id"),
            inverseJoinColumns = @JoinColumn(name = "purchase_item_id"))
    private List<PurchaseItem> purchaseItems = new ArrayList<>();

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @Column(name = "count")
    private int count;

    @Column(name = "amount")
    private int amount;

    @Column(name = "purchase_date")
    private Date datePurchase;



}
