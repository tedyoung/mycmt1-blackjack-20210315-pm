package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

// No longer useful and can be deleted
class SuitTest {

  @Test
  public void heartsAreRed() throws Exception {
    Suit hearts = Suit.HEARTS;

    assertThat(hearts.isRed())
        .isTrue();
  }

  @Test
  public void clubsAreNotRed() throws Exception {
    assertThat(Suit.CLUBS.isRed())
        .isFalse();
  }
}