package com.southeros.domain.model;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.southeros.domain.model.interfaces.Kingdom;
import com.southeros.domain.model.kingdom.KingdomFactory;
import com.southeros.enums.Kingdoms;
import com.southeros.utils.KingdomsAndKings;

public class KingTest {

    @Test
    public void testGetKing() {
        try{
            King king = new King(KingdomFactory.getKingdom(Kingdoms.AIR));
            Assert.assertEquals(KingdomsAndKings.getKing(Kingdoms.AIR), king.getKing());
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testSendMessageToKingdom() {
        try{
            Kingdom kingdom = KingdomFactory.getKingdom(Kingdoms.AIR);
            King king = new King(kingdom);
            Assert.assertEquals(KingdomsAndKings.getKing(Kingdoms.AIR), king.getKing());
            
            SecretMessage m1 = new SecretMessage();
            m1.setRecieverKingdom(KingdomFactory.getKingdom(Kingdoms.LAND));
            m1.setSenderKingdom(kingdom);
            m1.setSecretMessage("a1d22n333a4444p");
            
            SecretMessage m2 = new SecretMessage();
            m2.setRecieverKingdom(KingdomFactory.getKingdom(Kingdoms.SPACE));
            m2.setSenderKingdom(kingdom);
            m2.setSecretMessage("a1d22n333a4444p");
            
            List<SecretMessage> messages = new ArrayList<>();
            messages.add(m1);
            messages.add(m2);
            
            Set<Kingdom> allies = king.sendMessageToKingdom(messages);
            
            Assert.assertEquals(1, allies.size());
            
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

}
