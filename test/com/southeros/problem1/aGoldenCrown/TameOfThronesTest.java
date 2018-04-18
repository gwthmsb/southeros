package com.southeros.problem1.aGoldenCrown;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.southeros.domain.model.interfaces.Kingdom;
import com.southeros.domain.model.kingdom.KingdomFactory;
import com.southeros.enums.Kingdoms;
import com.southeros.utils.KingdomsAndKings;
import com.southeros.utils.Names;

public class TameOfThronesTest {

    @Test
    public void testGetKingOfSoutheros_validTestCase1() {
        try{
            TameOfThrones tameOfThrones = new TameOfThrones();
            List<String> messages = new ArrayList<>();
            
            messages.add("Air, \"oaaawaala\"");
            messages.add("Land, \"a1d22n333a4444p\"");
            messages.add("Ice, \"zmzmzmzaztzozh\"");
            
            Kingdom kingdom = KingdomFactory.getKingdom(Names.SPACE);
            tameOfThrones.sendMessagesToOtherKingdoms(messages, kingdom);

            Assert.assertEquals(Names.SPACE_KING, tameOfThrones.getKingOfSoutheros());
            Assert.assertEquals(3, tameOfThrones.getAlliesOfRulerAsSet().size());
            Assert.assertEquals("AIR, LAND, ICE", tameOfThrones.getAlliesOfRuler(Names.SPACE_KING));
            
        }catch(Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetKingOfSoutheros_validTestCase2() {
        try{
            TameOfThrones tameOfThrones = new TameOfThrones();
            List<String> messages = new ArrayList<>();
            
            messages.add("Air, \"Let’s swing the sword together\"");
            messages.add("Land, \"Die or play the tame of thrones\"");
            messages.add("Ice, \"Ahoy! Fight for me with men and money\"");
            messages.add("Water, \"Summer is coming\"");
            messages.add("Fire, \"Drag on Martin\"");
            
            Kingdom kingdom = KingdomFactory.getKingdom(Names.SPACE);
            tameOfThrones.sendMessagesToOtherKingdoms(messages, kingdom);

            Assert.assertEquals(Names.SPACE_KING, tameOfThrones.getKingOfSoutheros());
            Assert.assertEquals(4, tameOfThrones.getAlliesOfRulerAsSet().size());
            Assert.assertEquals("AIR, LAND, ICE, FIRE", tameOfThrones.getAlliesOfRuler(Names.SPACE_KING));
            
        }catch(Exception e){
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testGetKingOfSoutheros_validHalfDataTestCase() {
        try{
            TameOfThrones tameOfThrones = new TameOfThrones();
            List<String> messages = new ArrayList<>();
            
            messages.add("Air, \"Let’s swing the sword together\"");
            messages.add("Land, \"Die or play the tame of thrones\"");
            
            Kingdom kingdom = KingdomFactory.getKingdom(Names.SPACE);
            tameOfThrones.sendMessagesToOtherKingdoms(messages, kingdom);

            Assert.assertEquals(KingdomsAndKings.getKing(Kingdoms.NONE), tameOfThrones.getKingOfSoutheros());
            Assert.assertEquals(0, tameOfThrones.getAlliesOfRulerAsSet().size());
            Assert.assertEquals("None", tameOfThrones.getAlliesOfRuler(Names.SPACE_KING));
            
        }catch(Exception e){
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testGetKingOfSoutheros_emptyData(){
        try{
            TameOfThrones tameOfThrones = new TameOfThrones();
            List<String> messages = new ArrayList<>();
            
            Kingdom kingdom = KingdomFactory.getKingdom(Names.SPACE);
            tameOfThrones.sendMessagesToOtherKingdoms(messages, kingdom);

            Assert.assertEquals(KingdomsAndKings.getKing(Kingdoms.NONE), tameOfThrones.getKingOfSoutheros());
            Assert.assertEquals(0, tameOfThrones.getAlliesOfRulerAsSet().size());
            Assert.assertEquals("None", tameOfThrones.getAlliesOfRuler(Names.SPACE_KING));
            
        }catch(Exception e){
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testSendMessage_WrongKing() {
        try{
            TameOfThrones tameOfThrones = new TameOfThrones();
            
            List<String> messages = new ArrayList<>();
            Kingdom kingdom = KingdomFactory.getKingdom(Names.SPACE);
            tameOfThrones.sendMessagesToOtherKingdoms(messages, kingdom);

            Assert.assertEquals(KingdomsAndKings.getKing(Kingdoms.NONE), tameOfThrones.getKingOfSoutheros());
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testSendMessage_WrongKingWithCorrectMessage() {
        try{
            TameOfThrones tameOfThrones = new TameOfThrones();
            
            List<String> messages = new ArrayList<>();
            messages.add("Air, \"oaaawaala\"");
            messages.add("Land, \"a1d22n333a4444p\"");
            messages.add("Ice, \"zmzmzmzaztzozh\"");
            
            Kingdom kingdom = KingdomFactory.getKingdom(Names.NOMANSLAND);
            tameOfThrones.sendMessagesToOtherKingdoms(messages, kingdom);

            Assert.assertEquals(KingdomsAndKings.getKing(Kingdoms.NONE), tameOfThrones.getKingOfSoutheros());
        }catch(Exception e){
            fail(e.getMessage());
        }
    }
}
