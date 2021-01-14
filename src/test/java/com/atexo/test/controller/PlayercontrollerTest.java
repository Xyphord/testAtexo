package com.atexo.test.controller;

import com.atexo.test.InitSpringTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PlayercontrollerTest extends InitSpringTest {

    private static final Logger logger = LogManager.getLogger(PlayercontrollerTest.class);

    @Test
    public void testGetAllPlayrReturnNotfound(){
        ResultActions resultActions;
        try {
            resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/players"))
                    .andExpect(status().isNotFound()).andExpect(status().is(404));
            logger.info(resultActions.toString());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
