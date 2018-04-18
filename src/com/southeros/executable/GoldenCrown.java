package com.southeros.executable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.southeros.domain.model.interfaces.Kingdom;
import com.southeros.domain.model.kingdom.KingdomFactory;
import com.southeros.enums.Kingdoms;
import com.southeros.problem1.aGoldenCrown.TameOfThrones;

public class GoldenCrown {
    
    List<String> messages;
    Kingdom rulerAspirant;
    TameOfThrones tameOfThrones;
    
    public GoldenCrown(Kingdoms kingdomName){
        this.messages = new ArrayList<>();
        this.rulerAspirant = KingdomFactory.getKingdom(kingdomName);
        this.tameOfThrones = new TameOfThrones();
    }
    
    public static void main(String[] args){
        try{
            System.out.println("Input messages to kingdoms from King Shawn");
            System.out.println("Instructions : ");
            System.out.println("1. Input messages should be in format : Kingdom, Secret Message");
            System.out.println("2. End of input should be provided by marker - END");
            System.out.println("3. Only 5 lines of input can be provided");
            GoldenCrown goldenCrown = new GoldenCrown(Kingdoms.SPACE);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            int count=1;
            while(count<6 && ! "END".equals(line = reader.readLine())){
                goldenCrown.messages.add(line);
                count++;
            }
        
            goldenCrown.askKingdomToSendSecretMessages();
            goldenCrown.printKingInfo(); 
        }catch(IOException e){
            System.out.println("Input was intrupted");
            e.printStackTrace();
        }
    }
    
    private void askKingdomToSendSecretMessages(){
        this.tameOfThrones.sendMessagesToOtherKingdoms(messages, rulerAspirant);
    }
    
    private void printKingInfo(){
        System.out.println("Ruler of Southeros : "+this.tameOfThrones.getKingOfSoutheros());
        System.out.println("Allies of Ruler : "+this.tameOfThrones.getAlliesOfRuler(rulerAspirant.getKing()));
    }
}
