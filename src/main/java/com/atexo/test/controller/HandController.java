package com.atexo.test.controller;

import com.atexo.test.domain.Hand;
import com.atexo.test.domain.Player;
import com.atexo.test.service.HandService;
import com.atexo.test.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HandController {

    @Autowired
    private HandService handService;

    @Autowired
    private PlayerService playerService;

    @GetMapping(value="/hands", produces = { "application/json" })
    ResponseEntity<Map> all() {
        HashMap<String, Hand> hands = handService.getHands();
        if(hands == null){
            return errorJson("No hands in game.");
        }
        return successJson(hands);
    }

    @GetMapping(value="/hand/player/{name}", produces = { "application/json" })
    @ResponseBody
    ResponseEntity<Map>  hand(@PathVariable String name) {
        Player player = playerService.getPlayer(name);
        Hand hand = handService.getHand(player);
        if(hand == null){
            return errorJson("No hand found.");
        }
        return successJson(hand);
    }

    @GetMapping(value="/hand/player/{name}/sort/{order}", produces = { "application/json" })
    ResponseEntity<Map>  sortByOrder(@PathVariable String name, @PathVariable String order) {
        Player player = playerService.getPlayer(name);
        Hand hand = handService.getHand(player);
        handService.sortHand(hand, order);
        hand = handService.getHand(player);
        if(hand == null){
            return errorJson("No hand found.");
        }
        return successJson(hand);
    }

    @GetMapping(value="/hand/player/{name}/sort", produces = { "application/json" })
    ResponseEntity<Map>  sort(@PathVariable String name, @PathVariable String order) {
        Player player = playerService.getPlayer(name);
        Hand hand = handService.getHand(player);
        handService.sortHand(hand);
        hand = handService.getHand(player);
        if(hand == null){
            return errorJson("No hand found.");
        }
        return successJson(hand);
    }

    private ResponseEntity<Map> successJson(Object data) {
        Map responseJson= new HashMap();
        responseJson.put("status", "success");
        responseJson.put("data", data);
        return ResponseEntity.accepted().body(responseJson);
    }

    private ResponseEntity<Map> errorJson(String message) {
        Map responseJson = new HashMap();
        responseJson.put("status", "fail");
        responseJson.put("message", message);
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseJson);
    }
}
