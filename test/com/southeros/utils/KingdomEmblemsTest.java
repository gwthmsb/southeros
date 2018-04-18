package com.southeros.utils;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import com.southeros.enums.Kingdoms;

public class KingdomEmblemsTest {

    @Test
    public void testGetEmblem() {
        try{
            Assert.assertEquals(Names.OWL, KingdomEmblems.getEmblem(Kingdoms.AIR));
            Assert.assertEquals(Names.GORILLA, KingdomEmblems.getEmblem(Kingdoms.SPACE));
            Assert.assertEquals(Names.DRAGON, KingdomEmblems.getEmblem(Kingdoms.FIRE));
            Assert.assertEquals(Names.OCTOPUS, KingdomEmblems.getEmblem(Kingdoms.WATER));
            Assert.assertEquals(Names.PANDA, KingdomEmblems.getEmblem(Kingdoms.LAND));
            Assert.assertEquals(Names.MAMMOTH, KingdomEmblems.getEmblem(Kingdoms.ICE));
        }catch(Exception e){
            fail(e.getMessage());
        }
    }

}
