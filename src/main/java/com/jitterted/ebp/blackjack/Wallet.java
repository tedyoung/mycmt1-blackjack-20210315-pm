package com.jitterted.ebp.blackjack;

public class Wallet {

  private int balance;

  public Wallet() {
    balance = 0;
  }

  public boolean isEmpty() {
    return balance == 0;
  }

  public void addMoney(int amount) {
    requireGreaterThanZeroAmount(amount);
    balance += amount;
  }

  private void requireGreaterThanZeroAmount(int amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException();
    }
  }

  public int balance() {
    return balance;
  }

  public void bet(int betAmount) {
    requireSufficientBalanceFor(betAmount);
    balance -= betAmount;
  }

  private void requireSufficientBalanceFor(int betAmount) {
    if (balance < betAmount) {
      throw new IllegalStateException();
    }
  }
}
