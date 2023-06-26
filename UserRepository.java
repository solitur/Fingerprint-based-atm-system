package com.atm.repository;
import com.atm.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Integer> {
 Optional<User> findById(Long id);
 Optional<User> findByEmail(String email);
}