package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WalletTest {

  @Test
  public void newWalletIsEmpty() throws Exception {
    Wallet wallet = new Wallet();

    assertThat(wallet.isEmpty())
        .isTrue();
  }

  @Test
  public void newWalletAddMoneyThenIsNotEmpty() throws Exception {
    // (from BDD) GIVEN a new wallet
    Wallet wallet = new Wallet();

    // WHEN we add money
    wallet.addMoney(10);

    // THEN isEmpty is false
    assertThat(wallet.isEmpty())
        .isFalse();
  }

}
