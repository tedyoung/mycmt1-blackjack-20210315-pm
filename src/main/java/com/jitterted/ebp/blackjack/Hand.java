package com.jitterted.ebp.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.fusesource.jansi.Ansi.ansi;

public class Hand {
  private final List<Card> cards = new ArrayList<>();

  public Hand() {
  }

  public Hand(List<Card> cards) {
    this.cards.addAll(cards);
  }

  void drawCardFrom(Deck deck) {
    cards.add(deck.draw());
  }

  int value() {
    List<Card> hand1 = cards;
    int handValue = hand1
        .stream()
        .mapToInt(Card::rankValue)
        .sum();

    // does the hand contain at least 1 Ace?
    boolean hasAce = hand1
        .stream()
        .anyMatch(card -> card.rankValue() == 1);

    // if the total hand value <= 11, then count the Ace as 11 by adding 10
    if (hasAce && handValue <= 11) {
      handValue += 10;
    }

    return handValue;
  }

  void display() {
    System.out.println(cards.stream()
                            .map(Card::display)
                            .collect(Collectors.joining(
                               ansi().cursorUp(6).cursorRight(1).toString())));
  }

  Card firstCard() {
    return cards.get(0);
  }

  boolean dealerMustDrawCard() {
    return value() <= 16;
  }

  boolean isBusted() {
    return value() > 21;
  }

  boolean pushes(Hand hand) {
    return value() == hand.value();
  }

  boolean beats(Hand hand) {
    return hand.value() < value();
  }
}
