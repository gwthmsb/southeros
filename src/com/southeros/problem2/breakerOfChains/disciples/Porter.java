package com.southeros.problem2.breakerOfChains.disciples;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.southeros.decorator.KingdomDecorator;
import com.southeros.domain.model.SecretMessage;
import com.southeros.domain.model.interfaces.Kingdom;
import com.southeros.domain.model.kingdom.KingdomFactory;
import com.southeros.domain.model.kingdom.RulerAspirantKingdom;
import com.southeros.enums.Kingdoms;

public class Porter {

    private Set<Kingdoms> aspirantKingdoms;
    private Map<Kingdoms, Kingdom> kingdoms;
    private Map<Kingdoms, Set<Kingdom>> allies;
    
    public Porter(Set<Kingdoms> aspirantKingdoms){
        this.aspirantKingdoms = aspirantKingdoms;
        this.kingdoms = new EnumMap<Kingdoms, Kingdom>(Kingdoms.class);
        this.allies = new EnumMap<Kingdoms, Set<Kingdom>>(Kingdoms.class);
        this.startCorrespondance();
    }
    
    private void startCorrespondance(){
        for(Kingdoms kingdomName : Kingdoms.values()){
            Kingdom kingdom = KingdomFactory.getKingdom(kingdomName);
            if(aspirantKingdoms.contains(kingdomName))
                kingdom = KingdomDecorator.applyRulerAspirantDecorator(kingdom);
            this.kingdoms.put(kingdomName, kingdom);
        }
    }
    
    public Map<Kingdoms, Kingdom> getKingdomRepresents(){
        return kingdoms;
    }
    
    public Kingdom getKingdomRepresent(Kingdoms kingdomName){
        return kingdoms.get(kingdomName);
    }
    
    public void conveyHighPriestMessageToStopWar(Kingdoms kingdomName){
        Kingdom kingdom = kingdoms.get(kingdomName);
        if(kingdom instanceof RulerAspirantKingdom)
            ((RulerAspirantKingdom)kingdom).attainEnlightenmentToStopWar();
    }
    
    public void prepareForBallot(){
        Map<Kingdoms, Kingdom> ballotKingdoms = new EnumMap<Kingdoms, Kingdom>(Kingdoms.class);
        kingdoms.forEach((name, kingdom)->{
            Kingdom ballotKingdom = KingdomDecorator.applyBallotDecorator(kingdom, ballotKingdoms);
            ballotKingdoms.put(name, ballotKingdom);
        });
        this.kingdoms = ballotKingdoms;
    }
    
    public List<SecretMessage> conveySendMessage(){
        List<SecretMessage> messages = new ArrayList<>();
        
        aspirantKingdoms.forEach(kingdomName -> {
            Kingdom kingdom = kingdoms.get(kingdomName);
            kingdom.sendMessagesToKingdom();
            messages.addAll(kingdom.getSecretMessages());
        });
        return messages;
    }
    
    public void obtainAllegiance(List<SecretMessage> secretMessages){
        this.allies = new EnumMap<Kingdoms, Set<Kingdom>>(Kingdoms.class);
        secretMessages.forEach(message -> {
            if(message.getRecieverKingdom().obtainAllegiance(message)){
                Kingdoms aspirantKingdomName = message.getSenderKingdom().getKingdom();
                Set<Kingdom> allyKingdoms = allies.get(aspirantKingdomName);
                if(allyKingdoms ==null){
                    allyKingdoms= new LinkedHashSet<>();
                    allies.put(aspirantKingdomName, allyKingdoms);
                }
                allyKingdoms.add(message.getRecieverKingdom());
                
            }
        });
        aspirantKingdoms.forEach(kingdomName -> {
            Set<Kingdom> allyKingdoms = (allies.get(kingdomName)==null)?new LinkedHashSet<>():allies.get(kingdomName);
            kingdoms.get(kingdomName).setAllies(allyKingdoms);
        });
    }
    
    public void conveyKingdomsToAcceptAllegiance(){
        kingdoms.forEach((name, kingdom)-> {
          kingdom.setAllegiancePledged(null);  
        });
    }
}
