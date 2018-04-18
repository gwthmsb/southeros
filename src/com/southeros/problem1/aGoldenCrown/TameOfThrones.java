package com.southeros.problem1.aGoldenCrown;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.southeros.domain.model.SecretMessage;
import com.southeros.domain.model.SoutherosRuler;
import com.southeros.domain.model.interfaces.Kingdom;
import com.southeros.domain.model.kingdom.KingdomFactory;
import com.southeros.enums.Kingdoms;
import com.southeros.utils.KingdomsAndKings;
import com.southeros.utils.Names;

public class TameOfThrones {

    private SoutherosRuler southerosRuler;
    
    public TameOfThrones(){
        this.southerosRuler = new SoutherosRuler(KingdomFactory.getKingdom(Kingdoms.NONE));
    }
    
    public void sendMessagesToOtherKingdoms(List<String> messages, Kingdom rulerAspirant){
        try{
            if(!rulerAspirant.getKing().equals(Names.NOMANSLAND_KING)){
                List<SecretMessage> secretMessages = prepareSecretMessageReciever(messages);
                rulerAspirant.setSecretMessages(secretMessages);
                rulerAspirant.sendMessagesToKingdom();
                corronateKing(rulerAspirant);
            }else{
                System.out.println("Its lawless land");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public String getKingOfSoutheros(){
        return KingdomsAndKings.getKing(southerosRuler.getRuler());
    }
    
    public String getAlliesOfRuler(String king){
        if(KingdomsAndKings.getKing(southerosRuler.getRuler()).equals(king)){
            StringBuilder sb = new StringBuilder();
            southerosRuler.getAllies().forEach(ally-> sb.append(ally.getKingdom()+", "));
            
            String allies = sb.toString();
            if(allies.contains(", ")){
                allies = allies.substring(0, allies.length()-2);
            }
            return allies;
        }
        return "None";
    }
    
    public Set<Kingdom> getAlliesOfRulerAsSet(){
        return southerosRuler.getAllies();
    }
    
    private void corronateKing(Kingdom rulerAspirant){
        if(rulerAspirant.getAllies().size()>=3){
            southerosRuler.setRuler(rulerAspirant);
        }
    }
    
    private List<SecretMessage> prepareSecretMessageReciever(List<String> messages) throws Exception{
        List<SecretMessage> secretMessagesList = new ArrayList<>();
        for(String message : messages){
            SecretMessage secretMessage = new SecretMessage();
            String array[];
            if((array=(message.split(",",2))).length==2){
                secretMessage.setSecretMessage(array[1]);
                secretMessage.setRecieverKingdom(KingdomFactory.getKingdom(array[0]));
            }
            else
                throw new Exception("Error in secret message, its not formatted properly");
            secretMessagesList.add(secretMessage);
        }
        return secretMessagesList;
    }
}

