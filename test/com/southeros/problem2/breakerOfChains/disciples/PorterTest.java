package com.southeros.problem2.breakerOfChains.disciples;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.southeros.domain.model.SecretMessage;
import com.southeros.domain.model.interfaces.Ballot;
import com.southeros.domain.model.interfaces.Kingdom;
import com.southeros.domain.model.interfaces.RulerAspirant;
import com.southeros.domain.model.kingdom.RulerAspirantKingdom;
import com.southeros.enums.Kingdoms;
import com.southeros.problem2.breakerOfChains.disciples.Porter;

public class PorterTest {

    @Test
    public void testPorter() {
        try{
            Set<Kingdoms> aspirantKingdoms = new HashSet<>();
            aspirantKingdoms.add(Kingdoms.AIR);
            
            Porter porter = new Porter(aspirantKingdoms);
            
            Map<Kingdoms, Kingdom> kingdoms = porter.getKingdomRepresents();
            Assert.assertEquals(7, kingdoms.size());
            
            Kingdom rulerAspirantKingdom =  kingdoms.get(Kingdoms.AIR);
            Assert.assertTrue(rulerAspirantKingdom instanceof RulerAspirantKingdom);
            
            Assert.assertFalse(kingdoms.get(Kingdoms.LAND) instanceof RulerAspirantKingdom);
            Assert.assertFalse(kingdoms.get(Kingdoms.WATER) instanceof RulerAspirantKingdom);
            Assert.assertFalse(kingdoms.get(Kingdoms.ICE) instanceof RulerAspirantKingdom);
            Assert.assertFalse(kingdoms.get(Kingdoms.FIRE) instanceof RulerAspirantKingdom);
            Assert.assertFalse(kingdoms.get(Kingdoms.NONE) instanceof RulerAspirantKingdom);
            Assert.assertFalse(kingdoms.get(Kingdoms.SPACE) instanceof RulerAspirantKingdom);
            
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }


    @Test
    public void testGetKingdomRepresents() {
        try{
            Set<Kingdoms> aspirantKingdoms = new HashSet<>();
            aspirantKingdoms.add(Kingdoms.LAND);
            
            Porter porter = new Porter(aspirantKingdoms);
            
            Map<Kingdoms, Kingdom> kingdoms = porter.getKingdomRepresents();
            Assert.assertEquals(7, kingdoms.size());
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetKingdomRepresent() {
        try{
            Set<Kingdoms> aspirantKingdoms = new HashSet<>();
            aspirantKingdoms.add(Kingdoms.LAND);
            aspirantKingdoms.add(Kingdoms.AIR);
            aspirantKingdoms.add(Kingdoms.SPACE);
            
            Porter porter = new Porter(aspirantKingdoms);
            
            Assert.assertTrue(porter.getKingdomRepresent(Kingdoms.LAND) instanceof RulerAspirantKingdom);
            Assert.assertTrue(porter.getKingdomRepresent(Kingdoms.AIR) instanceof RulerAspirantKingdom);
            Assert.assertTrue(porter.getKingdomRepresent(Kingdoms.SPACE) instanceof RulerAspirantKingdom);
            Assert.assertFalse(porter.getKingdomRepresent(Kingdoms.ICE) instanceof RulerAspirantKingdom);
            Assert.assertFalse(porter.getKingdomRepresent(Kingdoms.FIRE) instanceof RulerAspirantKingdom);
            Assert.assertFalse(porter.getKingdomRepresent(Kingdoms.NONE) instanceof RulerAspirantKingdom);
            Assert.assertFalse(porter.getKingdomRepresent(Kingdoms.WATER) instanceof RulerAspirantKingdom);
            
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testConveyHighPriestMessageToStopWar() {
        try{
            Set<Kingdoms> aspirantKingdoms = new HashSet<>();
            aspirantKingdoms.add(Kingdoms.LAND);
            
            Porter porter = new Porter(aspirantKingdoms);
            Kingdom kingdom = porter.getKingdomRepresent(Kingdoms.LAND);
            
            SecretMessage message = new SecretMessage();
            message.setRecieverKingdom(kingdom);
            message.setSenderKingdom(porter.getKingdomRepresent(Kingdoms.AIR));
            message.setSecretMessage("a1d22n333a4444p");
            
            Assert.assertFalse(kingdom.obtainAllegiance(message));
            
            porter.conveyHighPriestMessageToStopWar(Kingdoms.LAND);
            Assert.assertTrue(kingdom.obtainAllegiance(message));
            Assert.assertTrue(kingdom.getAllegiancePledged().getKingdom().equals(Kingdoms.AIR));
            
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testPrepareForBallot() {
        try{
            Set<Kingdoms> aspirantKingdoms = new HashSet<>();
            aspirantKingdoms.add(Kingdoms.LAND);
            
            Porter porter = new Porter(aspirantKingdoms);
            Assert.assertTrue(porter.getKingdomRepresent(Kingdoms.AIR) instanceof Kingdom);
            Assert.assertFalse(porter.getKingdomRepresent(Kingdoms.AIR) instanceof Ballot);
            Assert.assertTrue(porter.getKingdomRepresent(Kingdoms.LAND) instanceof RulerAspirant);
            
            porter.prepareForBallot();
            Assert.assertTrue(porter.getKingdomRepresent(Kingdoms.AIR) instanceof Kingdom);
            Assert.assertTrue(porter.getKingdomRepresent(Kingdoms.AIR) instanceof Ballot);
            Assert.assertTrue(porter.getKingdomRepresent(Kingdoms.LAND) instanceof Ballot);
            Assert.assertFalse(porter.getKingdomRepresent(Kingdoms.LAND) instanceof RulerAspirant);
            
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testConveySendMessage() {
        try{
            Set<Kingdoms> aspirantKingdoms = new HashSet<>();
            aspirantKingdoms.add(Kingdoms.LAND);
            
            Porter porter = new Porter(aspirantKingdoms);
            Assert.assertEquals(0,porter.getKingdomRepresent(Kingdoms.LAND).getSecretMessages().size());
            porter.prepareForBallot();
            Assert.assertEquals(5, porter.conveySendMessage().size());
            
            aspirantKingdoms.add(Kingdoms.AIR);
            
            porter = new Porter(aspirantKingdoms);
            Assert.assertEquals(0,porter.getKingdomRepresent(Kingdoms.LAND).getSecretMessages().size());
            Assert.assertEquals(0,porter.getKingdomRepresent(Kingdoms.AIR).getSecretMessages().size());
            porter.prepareForBallot();
            Assert.assertEquals(10, porter.conveySendMessage().size());
            
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testObtainAllegiance() {
        try{
            Set<Kingdoms> aspirantKingdoms = new HashSet<>();
            aspirantKingdoms.add(Kingdoms.AIR);

            Porter porter = new Porter(aspirantKingdoms);
            Kingdom kingdom = porter.getKingdomRepresent(Kingdoms.LAND);
            
            SecretMessage message = new SecretMessage();
            message.setRecieverKingdom(kingdom);
            message.setSenderKingdom(porter.getKingdomRepresent(Kingdoms.AIR));
            message.setSecretMessage("a1d22n333a4444p");
            
            Kingdom kingdom2 = porter.getKingdomRepresent(Kingdoms.WATER);
            
            SecretMessage message2 = new SecretMessage();
            message2.setRecieverKingdom(kingdom2);
            message2.setSenderKingdom(porter.getKingdomRepresent(Kingdoms.AIR));
            message2.setSecretMessage("a1d22n333a4444p");
            
            List<SecretMessage> messages = new ArrayList<>();
            messages.add(message);
            messages.add(message2);
            
            porter.obtainAllegiance(messages);
            
            Assert.assertEquals(1, porter.getKingdomRepresent(Kingdoms.AIR).getAllies().size());
            
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

}
;