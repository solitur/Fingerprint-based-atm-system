package com.atm.entity;
import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "history")
public class History {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private int userId;
 private String type;
29
 private Double amount,accountBalance;
 private Timestamp createdTime;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public int getUserId() {
return userId;
}
public void setUserId(int userId) {
this.userId = userId;
}
public String getType() {
return type;
}
public void setType(String type) {
this.type = type;
}
public Double getAmount() {
return amount;
}
30
public void setAmount(Double amount) {
this.amount = amount;
}
public Double getAccountBalance() {
return accountBalance;
}
public void setAccountBalance(Double accountBalance) {
this.accountBalance = accountBalance;
}
public Timestamp getCreatedTime() {
return createdTime;
}
public void setCreatedTime(Timestamp createdTime) {
this.createdTime = createdTime;
} }