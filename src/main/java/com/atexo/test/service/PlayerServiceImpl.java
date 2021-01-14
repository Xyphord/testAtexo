package com.atexo.test.service;

import com.atexo.test.domain.Player;
import com.atexo.test.execption.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Value("${hand.size}")
    private int handSize ;

    private List<Player> players = new ArrayList<>();

    @Override
    public List<Player> getPlayers(){
        return players;
    }


    @Override
    public Player getPlayer(String name){
        if(players!=null){
            Optional<Player> player = players.stream().findFirst().filter(v -> v.getName().equals(name));
            if(player.isEmpty())
                throw new NotFoundException("Player "+name+ " not found.");
            return player.get();
        }
        else{
            throw new NotFoundException("no players found in game...");
        }
    }

    @Override
    public Player createPlayer(String name){
        if(players!=null){
            Player player = new Player(name, handSize);
            players.add(player);
            return player;
        }
        else{
            throw new NotFoundException("Players list is null !");
        }
    }

    @Override
    public void deletePlayer(Player player){
        if(players!=null){
            players.remove(player);
        }
    }

}
