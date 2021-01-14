package com.atexo.test.domain;

import java.util.EnumSet;
import java.util.Optional;

public enum CardValue {
    ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5) ,SIX(6), SEVEN(7), HEIGHT(8), NINE(9), TEN(10), JACk(11), QUEEN(12), KING(13);
    private int value;

    CardValue(int value) {
        this.value = value;
    }

    public static CardValue getCardValueByValue(int _status) {
        EnumSet<CardValue> cardValues= EnumSet.allOf(CardValue.class) ;
        Optional<CardValue> result =  cardValues.stream()
                .filter(num -> num.value == _status).findFirst();
        return result.get();
    }

    public int getValue() {
        return this.value;
    }

    public static int getSize(){
        EnumSet<CardValue> cards = EnumSet.allOf(CardValue.class) ;
        return cards.size();
    }
}
