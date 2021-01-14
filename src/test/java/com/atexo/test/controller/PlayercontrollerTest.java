package com.atexo.test.controller;

import com.atexo.test.InitSpringTest;
import com.atexo.test.service.PlayerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PlayercontrollerTest extends InitSpringTest {

    private static final Logger logger = LogManager.getLogger(PlayercontrollerTest.class);

    @Autowired
    private PlayerService playerService;

    @Test
    public void testGetAllPlayerReturnNotfound(){
        ResultActions resultActions;
        playerService.deleteAll();

        try {
            resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/players"))
                    .andExpect(status().isNotFound()).andExpect(status().is(404));
            logger.info(resultActions.toString());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void testGetAllPlayerReturnList(){
        playerService.createPlayer("one");
        playerService.createPlayer("two");

        ResultActions resultActions;
        try {
            resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/players"))
                    .andExpect(status().isOk());

            resultActions.andDo(MockMvcResultHandlers.print());
            logger.info(resultActions.andReturn().getResponse().getContentAsString());

            JSONObject resultat = new JSONObject(resultActions.andReturn().getResponse().getContentAsString());
            Assert.assertTrue(resultat.get("data") != null);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
