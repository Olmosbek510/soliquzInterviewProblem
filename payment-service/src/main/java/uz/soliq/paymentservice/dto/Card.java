package uz.soliq.paymentservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Card {
    private Integer id;
    private String cardNumber;
    private Integer userId;
    private Double balance;
}
