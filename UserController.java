package com.atm.controller;
import com.atm.entity.History;
import com.atm.entity.User;
import com.atm.repository.UserRepository;
import com.atm.services.UserService;
25
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("/")
public class UserController {
private static final Logger logger =
Logger.getLogger(UserController.class.getName());
 @Autowired
 private UserService userService;
 @GetMapping("/home")
26
 public String home(Model model, HttpSession session) {
 User user = (User) session.getAttribute("user");
 if(user!=null) {
 logger.info("Home Username :"+user.getName());
 user= userService.getUserById(user.getId()).get();
 model.addAttribute("user", user);
 model.addAttribute("name", user.getName());
 model.addAttribute("balance", user.getBalance());
 List<User> users = userService.getAllUsers();
 model.addAttribute("users", users);
 List<History> history = userService.getAllHistoryByUserId(user.getId());
 model.addAttribute("historyList", history);
 return "home";
 } else {
 return "redirect:/login";
 }
 }
 @GetMapping("/profile")
 public String profile(Model model, HttpSession session) {
 User user = (User)session.getAttribute("user");
 if(user!=null) {
 model.addAttribute("user",user);
 return "profile";
 } else {
27
 return "redirect:/login";
 }
 }
 @GetMapping("/client")
 public String client(Model model, HttpSession session) {
 model.addAttribute("user",session.getAttribute("user"));
 return "client";
 }
 @GetMapping("/users/{id}/edit")
 public String editUserForm(@PathVariable("id") Long id, Model model) {
 Optional<User> user = userService.getUserById(id);
 model.addAttribute("user", user);
 return "profile";
 }
 @PostMapping("/users/{id}/edit")
 public String updateUser(@PathVariable("id") Long id, @Valid User user,
BindingResult result,
 Model model,RedirectAttributes redirectAttributes, HttpSession session) {
 if (result.hasErrors()) {
 user.setId(id);
 model.addAttribute("user", user);
 model.addAttribute("error", "Invalid email or password");
 return "profile";
 }
28
 user = userService.updateUser(user);
 session.setAttribute("user", user);
 redirectAttributes.addFlashAttribute("success", "User details updated successfully.");
 redirectAttributes.addFlashAttribute("user", user);
 return "redirect:/profile";
 }}
