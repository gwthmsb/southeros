package com.southeros.utils;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import com.southeros.enums.Kingdoms;

public class KingdomsAndKingsTest {

    @Test
    public void testGetKing() {
        try{
            Assert.assertEquals(Names.AIR_KING, KingdomsAndKings.getKing(Kingdoms.AIR));
            Assert.assertEquals(Names.LAND_KING, KingdomsAndKings.getKing(Kingdoms.LAND));
            Assert.assertEquals(Names.ICE_KING, KingdomsAndKings.getKing(Kingdoms.ICE));
            Assert.assertEquals(Names.FIRE_KING, KingdomsAndKings.getKing(Kingdoms.FIRE));
            Assert.assertEquals(Names.WATER_KING, KingdomsAndKings.getKing(Kingdoms.WATER));
            Assert.assertEquals(Names.SPACE_KING, KingdomsAndKings.getKing(Kingdoms.SPACE));
            
        }catch(Exception e){
            fail(e.getMessage());
        }
    }

}
