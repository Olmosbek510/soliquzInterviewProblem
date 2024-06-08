package uz.soliq.cardservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.soliq.cardservice.entity.Card;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Integer> {
    List<Card> findByUserId(Integer userId);
}