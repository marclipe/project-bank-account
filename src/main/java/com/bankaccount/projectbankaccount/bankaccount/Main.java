package com.bankaccount.projectbankaccount.bankaccount;

public class Main {
  public static void main(String[] args) {
    AccountBank accountBank = new AccountBank();
    accountBank.setAccountOwner("Marcos");
    accountBank.setTypeAccount("cc");
//    accountBank.openAccount();
    accountBank.deposit(3000);
    accountBank.withdraw(38);
    accountBank.paymentMonthly();
    accountBank.withdraw(2538.0);
    accountBank.closeAccount();

    System.out.println("A conta: " + accountBank.getAccountOwner() + " - " + accountBank.getTypeAccount() + " - " + accountBank.getBalance());
  }
}
