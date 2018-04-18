package com.southeros.decorator;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.southeros.domain.model.SecretMessage;
import com.southeros.domain.model.interfaces.Kingdom;
import com.southeros.domain.model.kingdom.BallotKingdom;
import com.southeros.domain.model.kingdom.KingdomFactory;
import com.southeros.domain.model.kingdom.RulerAspirantKingdom;
import com.southeros.enums.Kingdoms;

public class KingdomDecoratorTest {

    @Test
    public void testApplyRulerAspirantDecorator() {
        try{
            Kingdom kingdom = KingdomFactory.getKingdom(Kingdoms.AIR);
            RulerAspirantKingdom rulerKingdom = KingdomDecorator.applyRulerAspirantDecorator(kingdom);
            
            Assert.assertTrue(rulerKingdom.isRulerAsprirant());
            Assert.assertEquals(kingdom.getKing(), rulerKingdom.getKing());
            Assert.assertEquals(kingdom.getEmblem(), rulerKingdom.getEmblem());
            Assert.assertEquals(kingdom.getAllegiancePledged(), rulerKingdom.getAllegiancePledged());
            Assert.assertEquals(kingdom.getKingdom(), rulerKingdom.getKingdom());
            Assert.assertEquals(kingdom.getMinister(), rulerKingdom.getMinister());
            
            String validWaterSM = "Water, Fear cuts deeper than swords My Lord";
            SecretMessage sm = new SecretMessage();
            sm.setRecieverKingdom(KingdomFactory.getKingdom(Kingdoms.WATER));
            sm.setSecretMessage(validWaterSM);
            
            List<SecretMessage> messageList = new ArrayList<>();
            messageList.add(sm);
            rulerKingdom.setSecretMessages(messageList);
            rulerKingdom.sendMessagesToKingdom();
            
            Assert.assertEquals(1, rulerKingdom.getAllies().size());
            
            SecretMessage secretMessage = new SecretMessage();
            secretMessage.setSecretMessage(validWaterSM);
            secretMessage.setRecieverKingdom(KingdomFactory.getKingdom(Kingdoms.WATER));
            secretMessage.setSenderKingdom(rulerKingdom);
            Assert.assertFalse(rulerKingdom.obtainAllegiance(secretMessage));
        }catch(Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void testApplyBallotDecorator() {
        try{
            Kingdom kingdom = KingdomFactory.getKingdom(Kingdoms.AIR);
            Map<Kingdoms, Kingdom> ballotKingdoms = new EnumMap<Kingdoms, Kingdom>(Kingdoms.class);
            ballotKingdoms.put(Kingdoms.FIRE, KingdomFactory.getKingdom(Kingdoms.FIRE));
            
            BallotKingdom ballotKingdom = KingdomDecorator.applyBallotDecorator(kingdom, ballotKingdoms);
            
            Assert.assertEquals(kingdom.getKing(), ballotKingdom.getKing());
            Assert.assertEquals(kingdom.getEmblem(), ballotKingdom.getEmblem());
            Assert.assertEquals(kingdom.getAllegiancePledged(), ballotKingdom.getAllegiancePledged());
            Assert.assertEquals(kingdom.getKingdom(), ballotKingdom.getKingdom());
            Assert.assertEquals(kingdom.getMinister(), ballotKingdom.getMinister());
            
            ballotKingdom.sendMessagesToKingdom();
            
            Assert.assertEquals(0, ballotKingdom.getAllies().size());
            Assert.assertEquals(5, ballotKingdom.getSecretMessages().size());
            
            SecretMessage secretMessage = new SecretMessage();
            secretMessage.setSecretMessage("oaaawaala");
            secretMessage.setRecieverKingdom(ballotKingdom);
            secretMessage.setSenderKingdom(KingdomFactory.getKingdom(Kingdoms.WATER));
            Assert.assertTrue(ballotKingdom.obtainAllegiance(secretMessage));
        }catch(Exception e){
            fail(e.getMessage());
        }
    }

}
