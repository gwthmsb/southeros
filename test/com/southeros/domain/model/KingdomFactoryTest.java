package com.southeros.domain.model;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import com.southeros.domain.model.interfaces.Kingdom;
import com.southeros.domain.model.kingdom.KingdomFactory;
import com.southeros.enums.Kingdoms;
import com.southeros.utils.KingdomEmblems;
import com.southeros.utils.Names;


public class KingdomFactoryTest {

    @Test
    public void testGetKingdomString() {
        try{
            Kingdom kingdom = KingdomFactory.getKingdom(Names.AIR);
            Assert.assertEquals(Kingdoms.AIR, kingdom.getKingdom());
            Assert.assertEquals(Names.AIR_KING, kingdom.getKing());
            Assert.assertEquals(KingdomEmblems.getEmblem(Kingdoms.AIR), kingdom.getEmblem());
            
            Assert.assertEquals(Kingdoms.LAND, KingdomFactory.getKingdom(Names.LAND).getKingdom());
            Assert.assertEquals(Kingdoms.WATER, KingdomFactory.getKingdom(Names.WATER).getKingdom());
            Assert.assertEquals(Kingdoms.SPACE, KingdomFactory.getKingdom(Names.SPACE).getKingdom());
            Assert.assertEquals(Kingdoms.ICE, KingdomFactory.getKingdom(Names.ICE).getKingdom());
            Assert.assertEquals(Kingdoms.FIRE, KingdomFactory.getKingdom(Names.FIRE).getKingdom());
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetKingdomKingdoms() {
        try{
            Kingdom kingdom = KingdomFactory.getKingdom(Kingdoms.AIR);
            Assert.assertEquals(Kingdoms.AIR, kingdom.getKingdom());
            Assert.assertEquals(Names.AIR_KING, kingdom.getKing());
            Assert.assertEquals(KingdomEmblems.getEmblem(Kingdoms.AIR), kingdom.getEmblem());
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

}
