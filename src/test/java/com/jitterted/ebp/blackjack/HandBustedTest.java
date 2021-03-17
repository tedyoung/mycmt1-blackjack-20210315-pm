package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandBustedTest {

  private static final Suit DUMMY_SUIT = Suit.HEARTS;

  @Test
  public void handValuedAt22IsBusted() throws Exception {
    Hand hand = createHand("9", "8", "5");

    assertThat(hand.isBusted())
        .isTrue();
  }

  @Test
  public void handValuedAs21IsNotBusted() throws Exception {
    Hand hand = createHand("9", "8", "4");

    assertThat(hand.isBusted())
        .isFalse();
  }

  @Test
  public void handValuedAs20IsNotBusted() throws Exception {
    Hand hand = createHand("9", "8", "3");

    assertThat(hand.isBusted())
        .isFalse();
  }

  private Hand createHand(String... ranks) {
    List<Card> cards = new ArrayList<>();
    for (String rank : ranks) {
      cards.add(new Card(DUMMY_SUIT, rank));
    }
    return new Hand(cards);
  }

}
