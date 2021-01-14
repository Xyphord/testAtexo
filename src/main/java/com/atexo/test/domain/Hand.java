package com.atexo.test.domain;

import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hand {

    @Value("{hand.default.sort.order}")
    private String sortOrder ;

    @Value("{hand.size}")
    private int handSize ;

    private String playerName;
    private List<Card> actualHand;


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public List<Card> getActualHand() {
        return actualHand;
    }

    public void setActualHand(List<Card> actualHand) {
        this.actualHand = actualHand;
    }

    public Hand(){
        Random rand = new Random();
        actualHand = new ArrayList<>();
        for(int i=0; i< handSize; i++)
            actualHand.add(
                    new Card(Color.getColorOrderByValue(rand.nextInt(Color.getSize())),
                    CardValue.getCardValueByValue(rand.nextInt(CardValue.getSize())+1)));

    }
}
