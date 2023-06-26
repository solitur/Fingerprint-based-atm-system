package com.atm.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
31
import jakarta.persistence.Table;
@Entity
@Table(name = "users")
public class User {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String name;
 private String email;
 private String password;
 private Double balance;
 @Column(name = "finger", columnDefinition = "LONGTEXT")
 private String finger;
 @Column(name = "fingerData", columnDefinition = "LONGTEXT")
 private String fingerData;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getName() {
return name;
}
32
public void setName(String name) {
this.name = name;
}
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}
public Double getBalance() {
return balance!=null?balance:0;
}
public void setBalance(Double balance) {
this.balance = balance;
}
public String getFinger() {
return finger;
33
}
public void setFinger(String finger) {
this.finger = finger;
}
public String getFingerData() {
return fingerData;
}
public void setFingerData(String fingerData) {
this.fingerData = fingerData;
}}