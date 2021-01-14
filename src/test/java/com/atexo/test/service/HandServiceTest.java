package com.atexo.test.service;

import com.atexo.test.InitSpringTest;
import com.atexo.test.domain.Hand;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class HandServiceTest extends InitSpringTest {
    private Hand hand = new Hand();

    @Before
    public void init(){
    }


    @Test
    public void testGoodHand(){
        assertEquals(hand.getActualHand().size(), 10);
        assertEquals(1,1);
    }
    @Test
    public void testGoodOrder(){

        assertEquals(1,1);
    }
}