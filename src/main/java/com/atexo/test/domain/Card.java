package com.atexo.test.domain;


import org.springframework.beans.factory.annotation.Value;

public class Card implements Comparable<Card>{

    private String sortOrder ;
    private CardValue cardValue;
    private Color color;

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }
    public CardValue getCardValue() {
        return cardValue;
    }

    public void setCardValue(CardValue cardValue) {
        this.cardValue = cardValue;
    }

    public Color getColor() {
        return color;
    }

    public void setColorOrder(Color color) {
        this.color = color;
    }

    public Card(Color color, CardValue cardValue){
        this.color = color;
        this.cardValue = cardValue;
    }

    public int compareTo(Card card) {
        if(sortOrder.equals("asc")) {
            int compareValue = this.color.compareTo(card.getColor());
            if(compareValue==0)
                return this.cardValue.compareTo(card.getCardValue());
        }
        else
        {
            int compareValue = card.getColor().compareTo(this.color);
            if(compareValue==0)
                return card.getCardValue().compareTo(this.cardValue);
        }
        return 0;
    }
}
