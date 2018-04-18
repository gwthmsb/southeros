package com.southeros.problem2.breakerOfChains;

import static org.junit.Assert.fail;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.southeros.enums.Kingdoms;
import com.southeros.problem2.breakerOfChains.HighPriest;

public class HighPriestTest {

    @Test
    public void testHighPriest() {
        try{
            Set<Kingdoms> aspirantKindomNames = new LinkedHashSet<>();
            aspirantKindomNames.add(Kingdoms.ICE);
            aspirantKindomNames.add(Kingdoms.LAND);
            
            
            HighPriest highPriest = new HighPriest(aspirantKindomNames);
            highPriest.conductBallot();
            
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }


    @Test
    public void testGetRulerOfSoutheros_noKingAspirant() {
        try{
            Set<Kingdoms> aspirantKindomNames = new LinkedHashSet<>();
            HighPriest highPriest = new HighPriest(aspirantKindomNames);
            highPriest.conductBallot();
            
            Assert.assertEquals(Kingdoms.NONE,highPriest.getKingOfSoutheros());
            
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetAlliesOfRuler_NoAspirant() {
        try{
            Set<Kingdoms> aspirantKindomNames = new LinkedHashSet<>();
            HighPriest highPriest = new HighPriest(aspirantKindomNames);
            highPriest.conductBallot();
            
            Assert.assertEquals(Kingdoms.NONE,highPriest.getKingOfSoutheros());
            Assert.assertEquals(0, highPriest.getAlliesOfRulerAsSet().size());
            Assert.assertEquals("None", highPriest.getAlliesOfRuler());
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testStartBallot_oneAspirant() {
        try{
            Set<Kingdoms> aspirantKindomNames = new LinkedHashSet<>();
            aspirantKindomNames.add(Kingdoms.AIR);
            HighPriest highPriest = new HighPriest(aspirantKindomNames);
            highPriest.conductBallot();
            
            Assert.assertEquals(Kingdoms.AIR, highPriest.getKingOfSoutheros());
            
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testStartBallot_twoAspirant() {
        try{
            Set<Kingdoms> aspirantKindomNames = new LinkedHashSet<>();
            aspirantKindomNames.add(Kingdoms.FIRE);
            aspirantKindomNames.add(Kingdoms.SPACE);
            
            HighPriest highPriest = new HighPriest(aspirantKindomNames);
            highPriest.conductBallot();
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testStartBallot_ThreeAspirant() {
        try{
            Set<Kingdoms> aspirantKindomNames = new LinkedHashSet<>();
            aspirantKindomNames.add(Kingdoms.FIRE);
            aspirantKindomNames.add(Kingdoms.AIR);
            aspirantKindomNames.add(Kingdoms.LAND);
            
            HighPriest highPriest = new HighPriest(aspirantKindomNames);
            highPriest.conductBallot();
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testStartBallot_FourAspirant() {
        try{
            Set<Kingdoms> aspirantKindomNames = new LinkedHashSet<>();
            aspirantKindomNames.add(Kingdoms.FIRE);
            aspirantKindomNames.add(Kingdoms.AIR);
            aspirantKindomNames.add(Kingdoms.SPACE);
            aspirantKindomNames.add(Kingdoms.LAND);
            
            HighPriest highPriest = new HighPriest(aspirantKindomNames);
            highPriest.conductBallot();
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

}
