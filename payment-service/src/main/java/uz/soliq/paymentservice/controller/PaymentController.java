package uz.soliq.paymentservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.soliq.paymentservice.client.CardClient;
import uz.soliq.paymentservice.dto.Card;
import uz.soliq.paymentservice.entity.Transaction;
import uz.soliq.paymentservice.repository.TransactionRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {
    private final CardClient cardClient;
    private final TransactionRepository transactionRepository;

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestParam Integer fromCardId, @RequestParam Integer toCardId, @RequestParam Double amount) {
        Card fromCard = cardClient.getCard(fromCardId);
        Card toCard = cardClient.getCard(toCardId);
        if (fromCard.getBalance() < amount) {
            return ResponseEntity.badRequest().body("Not enough money");
        }
        fromCard.setBalance(fromCard.getBalance() - amount);
        toCard.setBalance(toCard.getBalance() + amount);
        transactionRepository.save(Transaction.builder()
                .amount(amount)
                .fromCardId(fromCardId)
                .toCardId(toCardId)
                .build());
        cardClient.updateCard(fromCardId, fromCard);
        cardClient.updateCard(toCardId, toCard);
        return ResponseEntity.ok("Success");
    }
}
