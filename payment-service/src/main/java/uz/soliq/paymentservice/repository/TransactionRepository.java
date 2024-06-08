package uz.soliq.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.soliq.paymentservice.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}