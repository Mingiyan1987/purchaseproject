package ru.basanov.purchaseproject.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "age")
    private int age;

    @Column(name = "password")
    private char password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Purchase> purchase = new ArrayList<>();

}
