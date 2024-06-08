package uz.soliq.cardservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uz.soliq.userservice.entity.User;

@Getter
@Setter
@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private Integer userId;
    private String cardNumber;
    private double balance;
}