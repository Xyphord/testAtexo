package com.atexo.test.controller;

import com.atexo.test.domain.Player;
import com.atexo.test.execption.NotFoundException;
import com.atexo.test.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping(value="/players", produces = {  "application/json" })
    @ResponseBody
    ResponseEntity<Map> all() throws NotFoundException {
        Map responseJson= new HashMap();
        try {
            HashMap<String, Player> players = playerService.getPlayers();
            if(players == null || players.isEmpty()){
                return errorJson("No players in game.");
            }
            return successJson(players);
        }catch (NotFoundException nex){
            return errorJson(nex.getMessage());
        }
    }

    @GetMapping(value="/player/{name}", produces = {  "application/json" })
    @ResponseBody
    ResponseEntity<Map> player(@PathVariable String name) throws NotFoundException  {
        try {
            Player player = playerService.getPlayer(name);
            if(player == null){
                return errorJson("No player with name "+name+" in game.");
            }
            return successJson(player);
        }catch (NotFoundException nex){
            return errorJson(nex.getMessage());
        }
    }

    @PostMapping(value="/player/{name}/create", produces = { "application/json" })
    @ResponseBody
    ResponseEntity<Map> createPlayer(@PathVariable String name) {
        Map responseJson= new HashMap();
        Player player = playerService.createPlayer(name);
        if(player == null){
            return errorJson("create player fail.");
        }
        return successJson(player);
    }

    //PostMapping au lieu de DeleteMapping car je n'ai pas fait de requete ajax sur mon front.
    // Les verbes Delete et Put ne sont autorisés qu'en requete ajax sur les navigateurs modernes.
    @PostMapping(value="/player/{name}/delete", produces = { "application/json" })
    void deletePlayer(@PathVariable String name) {
        playerService.deletePlayer(name);
    }

    private ResponseEntity<Map> successJson(Object data) {
        Map responseJson = new HashMap();
        responseJson.put("status", "success");
        responseJson.put("data", data);
        return ResponseEntity.status(HttpStatus.OK).body(responseJson);
    }

    private ResponseEntity<Map> errorJson(String message) {
        Map responseJson = new HashMap();
        responseJson.put("status", "fail");
        responseJson.put("message", message);
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseJson);
    }
}
