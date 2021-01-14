package com.atexo.test.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hand {

    private List<Card> actualHand;

    public List<Card> getActualHand() {
        return actualHand;
    }

    public void setActualHand(List<Card> actualHand) {
        this.actualHand = actualHand;
    }

    public Hand(Integer handSize){
        Random rand = new Random();
        actualHand = new ArrayList<>();
        for(int i=0; i< handSize; i++)
            actualHand.add(
                    new Card(Color.getColorOrderByValue(rand.nextInt(Color.getSize())),
                    CardValue.getCardValueByValue(rand.nextInt(CardValue.getSize())+1)));

    }
}
