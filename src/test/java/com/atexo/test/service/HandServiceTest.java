package com.atexo.test.service;

import com.atexo.test.InitSpringTest;
import com.atexo.test.domain.CardValue;
import com.atexo.test.domain.Color;
import com.atexo.test.domain.Hand;
import com.atexo.test.domain.Player;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class HandServiceTest extends InitSpringTest {
    private Player player = new Player("one",10);

    @Autowired
    private HandService handService;

    @Test
    public void testGoodHand(){
        Hand hand = handService.getHand(player);
        Assert.assertEquals(hand.getActualHand().size(), 10);
    }

    @Test
    public void testGoodOrder(){
        Hand hand = handService.getHand(player);
        hand.getActualHand().get(0).setColorOrder(Color.CLUBS);
        hand.getActualHand().get(0).setCardValue(CardValue.KING);

        hand.getActualHand().get(9).setColorOrder(Color.DIAMONDS);
        hand.getActualHand().get(9).setCardValue(CardValue.ACE);
        handService.sortHand(hand);
        player.setHand(hand);
        Assert.assertEquals(player.getHand().getActualHand().get(0).getCardValueInt() ,1);
        Assert.assertEquals(player.getHand().getActualHand().get(0).getColorInt() ,0);
        Assert.assertEquals(player.getHand().getActualHand().get(9).getCardValueInt() ,13);
        Assert.assertEquals(player.getHand().getActualHand().get(9).getColorInt() ,3);
    }
}