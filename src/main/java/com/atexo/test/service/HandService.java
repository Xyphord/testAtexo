package com.atexo.test.service;

import com.atexo.test.domain.Card;
import com.atexo.test.domain.Hand;
import com.atexo.test.domain.Player;

import java.util.HashMap;
import java.util.List;

public interface HandService {
    HashMap<String, Hand> getHands();
    Hand getHand(Player player);
    void sortHand(Hand hand);
    void sortHand(Hand han, String order);
}
