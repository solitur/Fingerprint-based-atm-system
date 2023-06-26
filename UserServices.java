package com.atm.services;
import java.util.List;
import java.util.Optional;
import com.atm.entity.History;
import com.atm.entity.User;
public interface UserService {
Optional<User> getUserById(Long id);
Optional<User> getUserByEmail(String email);
 User updateUser(User user);
 List<User> getAllUsers();
 List<History> getAllHistoryByUserId(Long userId);
 History updateHistory(History hist);
}