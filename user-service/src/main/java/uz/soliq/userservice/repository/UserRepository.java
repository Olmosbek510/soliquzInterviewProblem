package uz.soliq.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.soliq.userservice.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}