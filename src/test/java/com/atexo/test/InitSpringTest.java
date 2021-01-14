package com.atexo.test;

import com.atexo.test.configuration.WebConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfiguration.class)
@SpringBootTest(classes = {CardsApplication.class})
@TestPropertySource(locations="classpath:cards.properties")
public class InitSpringTest {

    private static final Logger logger = LogManager.getLogger(InitSpringTest.class);
    @Autowired
    protected WebApplicationContext wac;

    protected MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .build();
    }

    @Test
    public void testVersionController(){
        ResultActions resultActions;
        try {
            resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/version"))
                    .andExpect(status().isOk());
            logger.info(resultActions.toString());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
