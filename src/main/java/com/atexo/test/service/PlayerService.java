package com.atexo.test.service;

import com.atexo.test.domain.Player;

import java.util.HashMap;
import java.util.List;

public interface  PlayerService {

    Player getPlayer(String name);
    HashMap<String, Player> getPlayers();
    Player createPlayer(String name);

    void deletePlayer(String name);
    void deleteAll();
}
