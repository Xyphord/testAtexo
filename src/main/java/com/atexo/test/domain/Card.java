package com.atexo.test.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Value;

public class Card implements Comparable<Card>{

    @JsonIgnore
    private String sortOrder ;
    private CardValue cardValue;
    private int cardValueInt;
    private Color color;
    private int colorInt;

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
        this.cardValueInt = cardValue.getValue();
    }

    public Color getColor() {
        return color;
    }

    public void setColorOrder(Color color) {
        this.color = color;
        this.colorInt = color.getOrder();
    }

    public Card(Color color, CardValue cardValue){
        this.color = color;
        this.colorInt = color.getOrder();
        this.cardValue = cardValue;
        this.cardValueInt = cardValue.getValue();
    }

    public int compareTo(Card card) {
        int compareValue;
        if(sortOrder != null && sortOrder.equals("desc")) {
            compareValue = card.getColor().getOrder() - this.color.getOrder();
            if(compareValue==0)
                return card.getCardValue().getValue() - this.cardValue.getValue() ;
        }
        else
        {
            compareValue = this.color.getOrder() - card.getColor().getOrder();
            if(compareValue==0)
                return this.cardValue.getValue() - card.getCardValue().getValue();
        }
        return compareValue;
    }

    public int getColorInt() {
        return colorInt;
    }

    public void setColorInt(int colorInt) {
        this.colorInt = colorInt;
    }

    public int getCardValueInt() {
        return cardValueInt;
    }

    public void setCardValueInt(int cardValueInt) {
        this.cardValueInt = cardValueInt;
    }
}
