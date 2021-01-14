package com.atexo.test.service;

import com.atexo.test.domain.Player;
import com.atexo.test.execption.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Value("${hand.size}")
    private int handSize ;

    private HashMap<String, Player> players = new HashMap<>();

    @Override
    public  HashMap<String, Player> getPlayers(){
        return players;
    }


    @Override
    public Player getPlayer(String name){
        if(players != null){
            Player player = players.get(name);
            if(player == null)
                throw new NotFoundException("Player "+name+ " not found.");
            return player;
        }
        else{
            throw new NotFoundException("no players found in game...");
        }
    }

    @Override
    public Player createPlayer(String name){
        if(players!=null){
            Player player = new Player(name, handSize);
            players.put(name, player);
            return player;
        }
        else{
            throw new NotFoundException("Players list is null !");
        }
    }

    @Override
    public void deletePlayer(String name){
        if(players!=null){
            players.remove(name);
        }
    }
    @Override
    public void deleteAll(){
        if(players!=null){
            players.clear();
        }
    }

}
