package com.atexo.test.service;

import com.atexo.test.domain.Player;
import com.atexo.test.execption.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    private List<Player> players;

    @Override
    public List<Player> getPlayers(){
        return players;
    }


    @Override
    public Player getPlayer(String name){
        if(players!=null){
            Optional<Player> player = players.stream().findFirst().filter(v -> v.getName().equals(name));
            return player.get();
        }
        else{
            throw new NotFoundException("no players found in game...");
        }
    }

    @Override
    public Player createPlayer(String name){
        if(players!=null){
            Player player = new Player(name);
            players.add(player);
            return player;
        }
        else{
            throw new NotFoundException("no player found in game...");
        }
    }

    @Override
    public void deletePlayer(Player player){
        if(players!=null){
            players.remove(player);
        }
    }

}
