package com.southeros.problem2.breakerOfChains.disciples;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.southeros.domain.model.SecretMessage;
import com.southeros.domain.model.interfaces.Kingdom;
import com.southeros.domain.model.kingdom.KingdomFactory;
import com.southeros.enums.Kingdoms;

public class BallotConductorTest {

    @Test
    public void testBallotConductor_validcase1() {
        try{
            Set<Kingdoms> aspirantKingdoms = new HashSet<>();
            aspirantKingdoms.add(Kingdoms.AIR);
            
            Porter porter = new Porter(aspirantKingdoms);
            
            List<SecretMessage> randomMessages = new ArrayList<>();
            
            SecretMessage message = new SecretMessage();
            message.setRecieverKingdom(KingdomFactory.getKingdom(Kingdoms.LAND));
            message.setSenderKingdom(porter.getKingdomRepresent(Kingdoms.AIR));
            message.setSecretMessage("a1d22n333a4444p");
            
            randomMessages.add(message);
            
            BallotConductor ballotConductor = new BallotConductor(porter, aspirantKingdoms, randomMessages);
            ballotConductor.conductBallot();
            Set<Kingdom> ballotLeadingKingdoms = ballotConductor.findBallotLeadingKingdoms();
            
            Assert.assertEquals(1, ballotLeadingKingdoms.size());
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testBallotConductor_validcase2() {
        try{
            Set<Kingdoms> aspirantKingdoms = new HashSet<>();
            aspirantKingdoms.add(Kingdoms.AIR);
            aspirantKingdoms.add(Kingdoms.SPACE);
            
            Porter porter = new Porter(aspirantKingdoms);
            
            List<SecretMessage> randomMessages = new ArrayList<>();
            
            SecretMessage message = new SecretMessage();
            message.setRecieverKingdom(KingdomFactory.getKingdom(Kingdoms.LAND));
            message.setSenderKingdom(porter.getKingdomRepresent(Kingdoms.AIR));
            message.setSecretMessage("a1d22n333a4444p");
            
            SecretMessage message2 = new SecretMessage();
            message2.setRecieverKingdom(KingdomFactory.getKingdom(Kingdoms.LAND));
            message2.setSenderKingdom(porter.getKingdomRepresent(Kingdoms.SPACE));
            message2.setSecretMessage("a1d22n333a4444p");
            
            randomMessages.add(message);
            randomMessages.add(message2);
            
            BallotConductor ballotConductor = new BallotConductor(porter, aspirantKingdoms, randomMessages);
            ballotConductor.conductBallot();
            Set<Kingdom> ballotLeadingKingdoms = ballotConductor.findBallotLeadingKingdoms();
            
            Assert.assertEquals(2, ballotLeadingKingdoms.size());
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
}
