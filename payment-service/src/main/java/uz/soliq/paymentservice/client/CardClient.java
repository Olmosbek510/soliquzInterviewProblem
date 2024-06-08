package uz.soliq.paymentservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uz.soliq.cardservice.entity.Card;

@FeignClient(name = "card-service")
public interface CardClient {
    @GetMapping("/cards/{id}")
    Card getCard(@PathVariable Integer id);
    @PutMapping("/cards/{id}")
    Card updateCard(@PathVariable Integer id, @RequestBody Card card);
}
