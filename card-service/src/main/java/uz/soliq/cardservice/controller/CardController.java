package uz.soliq.cardservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.cardservice.entity.Card;
import uz.soliq.cardservice.repository.CardRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardController {
    private final CardRepository cardRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCard(@PathVariable(name = "id") Integer id) {
        return cardRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Card>> getCardsByUserId(@PathVariable(name = "id")Integer id){
        return ResponseEntity.ok(cardRepository.findByUserId(id));
    }

    @PostMapping
    public ResponseEntity<Card>createCard(@RequestBody Card card){
        return ResponseEntity.ok(cardRepository.save(card));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> updateCard(@PathVariable Integer id, @RequestBody Card updatedCard) {
        Optional<Card> card = cardRepository.findById(id);
        if(card.isPresent()){
            Card existingCard = card.get();
            existingCard.setBalance(updatedCard.getBalance());
            Card savedCard = cardRepository.save(existingCard);
            return ResponseEntity.ok(savedCard);
        }
        return ResponseEntity.badRequest().build();
    }
}
