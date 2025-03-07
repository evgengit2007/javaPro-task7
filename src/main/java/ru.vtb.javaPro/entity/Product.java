package ru.vtb.javaPro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "balance")
    private double balance;

    @Column(name = "type_products")
    private String typeProducts;

    @Column(name = "user_id")
    private Long user;

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance='" + balance + '\'' +
                ", typeProducts=" + typeProducts +
                ", user=" + user +
                '}';
    }
}
