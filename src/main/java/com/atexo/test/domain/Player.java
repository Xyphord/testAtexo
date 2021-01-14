package com.atexo.test.domain;

public class Player {
    private String name;
    private Hand hand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Player(String name){
        this.name = name;
        this.hand = new Hand();
    }
}
