package com.southeros.domain.model;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import com.southeros.domain.model.interfaces.Kingdom;
import com.southeros.domain.model.kingdom.KingdomFactory;
import com.southeros.enums.Kingdoms;

public class MinisterTest {

    @Test
    public void testDecodeMessage() {
        try{
            Kingdom space = KingdomFactory.getKingdom(Kingdoms.SPACE);
            Kingdom water = KingdomFactory.getKingdom(Kingdoms.WATER);
            Kingdom ice = KingdomFactory.getKingdom(Kingdoms.ICE);
            Kingdom land = KingdomFactory.getKingdom(Kingdoms.LAND);
            Kingdom fire = KingdomFactory.getKingdom(Kingdoms.FIRE);
            Kingdom air = KingdomFactory.getKingdom(Kingdoms.AIR);
            
            String waterValidMessage = "Fear cuts deeper than swords My Lord";
            String spaceValidMessage = "Go ring all the bells";
            String iceValidMessage = "Different roads sometimes lead to the same castle.";
            String landValidMessage = "a1d22n333a4444p";
            String fireValidMessage = "Drag on Martin!";
            String airValidMessage = "oaaawaala";
            
            Assert.assertTrue((new Minister(water)).decodeMessage(waterValidMessage));
            Assert.assertTrue((new Minister(space)).decodeMessage(spaceValidMessage));
            Assert.assertTrue((new Minister(air)).decodeMessage(airValidMessage));
            Assert.assertTrue((new Minister(land)).decodeMessage(landValidMessage));
            Assert.assertTrue((new Minister(fire)).decodeMessage(fireValidMessage));
            Assert.assertTrue((new Minister(ice)).decodeMessage(iceValidMessage));
            
            Assert.assertFalse((new Minister(water)).decodeMessage(spaceValidMessage));
            Assert.assertFalse((new Minister(space)).decodeMessage(airValidMessage));
            Assert.assertFalse((new Minister(air)).decodeMessage(landValidMessage));
            Assert.assertFalse((new Minister(land)).decodeMessage(fireValidMessage));
            Assert.assertFalse((new Minister(fire)).decodeMessage(iceValidMessage));
            Assert.assertFalse((new Minister(ice)).decodeMessage(waterValidMessage));
            
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testWriteSecretMessage() {
        try{
            Kingdom space = KingdomFactory.getKingdom(Kingdoms.SPACE);
            Minister minister = new Minister(space);
            String message = "Go ring all the bells";
            
            SecretMessage sm = new SecretMessage();
            sm.setRecieverKingdom(KingdomFactory.getKingdom(Kingdoms.WATER));
            sm.setSecretMessage(message);
            
            SecretMessage secretMessage = minister.writeSecretMessage(sm);
            
            Assert.assertEquals(Kingdoms.WATER, secretMessage.getRecieverKingdom().getKingdom());
            Assert.assertEquals(Kingdoms.SPACE, secretMessage.getSenderKingdom().getKingdom());
            Assert.assertEquals("Go ring all the bells", secretMessage.getSecretMessage());
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

}
