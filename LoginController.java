package com.atm.controller;
22
import com.atm.entity.History;
import com.atm.entity.User;
import com.atm.object.RequestObj;
import com.atm.services.UserService;
import jakarta.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/atm")
public class ATMController {
private static final Logger logger = Logger.getLogger(ATMController.class.getName());
 @Autowired
 private UserService userService;
23
 // @ResponseBody
 @PostMapping(value="/u/{id}/deposit")
 public ResponseEntity<String> deposit(@PathVariable("id") Long id, @RequestBody
RequestObj obj,HttpSession session) {
 Optional<User> user = userService.getUserById(id);
 String result = "ERROR";
 if(user.isPresent()) {
 User u = user.get();
 u.setBalance(u.getBalance() + obj.getAmount());
 userService.updateUser(u);
 result = "SUCCESS";
 session.setAttribute("user", u);
 History h = new History();
 h.setAmount(obj.getAmount());
 h.setAccountBalance(u.getBalance());
 h.setUserId(u.getId().intValue());
 h.setType("Deposit");
 h.setCreatedTime(new Timestamp(System.currentTimeMillis()));
 userService.updateHistory(h);
 }
 return new ResponseEntity<>(result, HttpStatus.OK);
 }
 @PostMapping("/u/{id}/withdraw")
 public String withdraw(@PathVariable("id") Long id, @RequestBody RequestObj
obj,HttpSession session) {
24
 Optional<User> user = userService.getUserById(id);
 String result = "ERROR";
 if(user.isPresent()) {
 User u = user.get();
 u.setBalance(u.getBalance() - obj.getAmount());
 userService.updateUser(u);
 result = "SUCCESS";
 session.setAttribute("user", u);
 History h = new History();
 h.setAmount(obj.getAmount());
 h.setAccountBalance(u.getBalance());
 h.setUserId(u.getId().intValue());
 h.setType("Withdraw");
 h.setCreatedTime(new Timestamp(System.currentTimeMillis()));
 userService.updateHistory(h);
 }
 return result;
 }}
