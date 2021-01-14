package com.atexo.test.service;

import com.atexo.test.domain.Player;

import java.util.List;

public interface  PlayerService {

    Player getPlayer(String name);
    List<Player> getPlayers();
    Player createPlayer(String name);

    void deletePlayer(Player player);
}
