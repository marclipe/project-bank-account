package com.bankaccount.projectbankaccount.bankaccount;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/accountBank")
public class AccountBank {
  public String numberAccount;
  protected String typeAccount; //cc - cp
  private String accountOwner;
  private double balance;
  private boolean statusAccount;

  public String getNumberAccount() {
    return numberAccount;
  }

  public void setNumberAccount(String numberAccount) {
    this.numberAccount = numberAccount;
  }

  public String getTypeAccount() {
    return typeAccount;
  }

  public void setTypeAccount(String typeAccount) {
    this.typeAccount = typeAccount;
  }

  public String getAccountOwner() {
    return accountOwner;
  }

  public void setAccountOwner(String accountOwner) {
    this.accountOwner = accountOwner;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public boolean isStatusAccount() {
    return statusAccount;
  }

  public void setStatusAccount(boolean statusAccount) {
    this.statusAccount = statusAccount;
  }

  //Constructor
  public AccountBank() {
    this.balance = 0;
    this.statusAccount = false;
  }

//  public void openAccount() {
//    statusAccount = true;
//    if (typeAccount == "cc") {
//      System.out.println("Conta Corrente");
//      balance = balance + 50;
//    } else if(typeAccount == "cp") {
//      System.out.println("Conta Poupança");
//      balance = balance + 150;
//    }
//  }

  @GetMapping("/openAccount/{typeAccount}")
  public ResponseEntity<Object> openAccount(@PathVariable String typeAccount) {
    statusAccount = true;
    if (Objects.equals(typeAccount, "cc")) {
      return ResponseEntity.status(HttpStatus.OK).body(typeAccount + " Conta Corrente!");
    } else if(Objects.equals(typeAccount, "cp")) {
      return ResponseEntity.status(HttpStatus.OK).body(typeAccount + " Conta Poupança!");
    }
    return ResponseEntity.badRequest().body("Não foi possível abrir a conta!");
  }

  public void closeAccount() {
    if (balance == 0) {
      statusAccount = false;
      System.out.println("Conta fechada com sucesso!");
    } else {
      System.out.println("Não foi possível realizar o fechamento da conta :(");
    }
  }
  public void deposit(double valueDeposit) {
    if(statusAccount) {
      balance = balance + valueDeposit;
      System.out.println("Valor de R$ " + valueDeposit + " depositado com sucesso!");
    } else {
      System.out.println("Não foi possível fazer o depósito!");
    }
  }
  public void withdraw(double valueWithDraw) {
    if(statusAccount && balance > valueWithDraw) {
      balance = balance - valueWithDraw;
      System.out.println("Valor de R$ " + valueWithDraw + " foi sacado com sucesso!");
    } else {
      System.out.println("Não foi possível fazer o saque!");
    }
  }
  public void paymentMonthly() {
    if(typeAccount == "cc") {
      balance = balance - 12;
    } else if(typeAccount == "cp") {
      balance = balance - 20;
    }
  }
}
