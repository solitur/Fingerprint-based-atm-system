package com.atm.servicesImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atm.entity.History;
import com.atm.entity.User;
36
import com.atm.repository.HistoryRepository;
import com.atm.repository.UserRepository;
import com.atm.services.UserService;
@Service
public class UserServiceImpl implements UserService {
 @Autowired
 private UserRepository userRepository;
 @Autowired
 private HistoryRepository histRepository;
 @Override
 public Optional<User> getUserById(Long id) {
 return userRepository.findById(id).map(user ->
Optional.of(user)).orElse(Optional.empty());
 }
 @Override
 public Optional<User> getUserByEmail(String email) {
 return userRepository.findByEmail(email).map(user ->
Optional.of(user)).orElse(Optional.empty());
 }
 @Override
 public User updateUser(User user) {
 return userRepository.save(user);
 }
 @Override
 public List<User> getAllUsers() {
37
 return userRepository.findAll();
 }
 @Override
 public History updateHistory(History hist) {
 return histRepository.save(hist);
 }
 @Override
 public List<History> getAllHistoryByUserId(Long userId) {
 return histRepository.findAllHistoryByUserId(userId);
 }
}