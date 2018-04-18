package com.southeros.problem2.breakerOfChains.disciples;

import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.southeros.domain.model.interfaces.Kingdom;
import com.southeros.domain.model.kingdom.KingdomFactory;
import com.southeros.enums.Kingdoms;
import com.southeros.problem2.breakerOfChains.disciples.BallotCounter;
import com.southeros.problem2.breakerOfChains.disciples.Porter;

public class BallotCounterTest {

    @Test
    public void testBallotCounter_validTestcase1() {
        try{
            Set<Kingdoms> aspirantKingdoms = new HashSet<>();
            aspirantKingdoms.add(Kingdoms.LAND);
            aspirantKingdoms.add(Kingdoms.AIR);
            aspirantKingdoms.add(Kingdoms.SPACE);
            
            Set<Kingdom> alliesLand = new HashSet<>();
            alliesLand.add(KingdomFactory.getKingdom(Kingdoms.SPACE));
            alliesLand.add(KingdomFactory.getKingdom(Kingdoms.ICE));
            
            Set<Kingdom> alliesAir = new HashSet<>();
            alliesAir.add(KingdomFactory.getKingdom(Kingdoms.SPACE));
            
            Porter porter = new Porter(aspirantKingdoms);
            porter.getKingdomRepresent(Kingdoms.LAND).setAllies(alliesLand);
            porter.getKingdomRepresent(Kingdoms.AIR).setAllies(alliesAir);
            
            BallotCounter ballotCounter = new BallotCounter(aspirantKingdoms, porter);
            ballotCounter.countBallot();
            
            Assert.assertEquals(1, ballotCounter.findBallotLeadingKingdoms().size());
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testBallotCounter_validTestcase2() {
        try{
            Set<Kingdoms> aspirantKingdoms = new HashSet<>();
            aspirantKingdoms.add(Kingdoms.LAND);
            aspirantKingdoms.add(Kingdoms.AIR);
            aspirantKingdoms.add(Kingdoms.SPACE);
            
            Set<Kingdom> alliesLand = new HashSet<>();
            alliesLand.add(KingdomFactory.getKingdom(Kingdoms.SPACE));
            alliesLand.add(KingdomFactory.getKingdom(Kingdoms.ICE));
            
            Set<Kingdom> alliesAir = new HashSet<>();
            alliesAir.add(KingdomFactory.getKingdom(Kingdoms.SPACE));
            alliesAir.add(KingdomFactory.getKingdom(Kingdoms.ICE));
            
            Porter porter = new Porter(aspirantKingdoms);
            porter.getKingdomRepresent(Kingdoms.LAND).setAllies(alliesLand);
            porter.getKingdomRepresent(Kingdoms.AIR).setAllies(alliesAir);
            
            BallotCounter ballotCounter = new BallotCounter(aspirantKingdoms, porter);
            ballotCounter.countBallot();
            
            Assert.assertEquals(2, ballotCounter.findBallotLeadingKingdoms().size());
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
}
