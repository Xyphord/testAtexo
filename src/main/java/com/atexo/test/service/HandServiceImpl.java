package com.atexo.test.service;

import com.atexo.test.domain.Card;
import com.atexo.test.domain.Hand;
import com.atexo.test.domain.Player;
import com.atexo.test.execption.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HandServiceImpl implements HandService {

    @Autowired
    private PlayerService playerService;

    @Value("${hand.default.sort.order}")
    private String sortOrder ;

    @Value("${hand.size}")
    private int handSize ;

    @Override
    public void sortHand(Hand hand){
        sortHand(hand, sortOrder);
    }

    @Override
    public void sortHand(Hand hand, String overridedSortOrder){

        Collections.addAll(hand.getActualHand());
        Collections.sort(hand.getActualHand(),new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                c1.setSortOrder(overridedSortOrder);
                c2.setSortOrder(overridedSortOrder);
                return c1.compareTo(c2);
            }
        });
    }

    @Override
    public Hand getHand(Player player) {
        return player.getHand();
    }

    @Override
    public HashMap<String, Hand> getHands() {
        HashMap<String, Hand> hands = new HashMap<>();
        HashMap<String, Player> players = playerService.getPlayers();
        if(players != null){
            for(String key: players.keySet()){
                Player player = players.get(key);
                if(player != null && player.getHand() != null)
                    hands.put(key, player.getHand());
            }
        }
        else{
            throw new NotFoundException("no players found in game...");
        }
        return hands;
    }
}
