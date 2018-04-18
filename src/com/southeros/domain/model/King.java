package com.southeros.domain.model;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.southeros.domain.model.interfaces.Kingdom;
import com.southeros.utils.KingdomsAndKings;

public class King {

    private Kingdom kingdom;
    private String king;
    
    public King(Kingdom kingdom){
        this.kingdom = kingdom;
        this.king = KingdomsAndKings.getKing(kingdom.getKingdom());
    }

    public String getKing(){
        return king;
    }
    
    public Set<Kingdom> sendMessageToKingdom(List<SecretMessage> messages){
        Set<Kingdom> allies = new LinkedHashSet<>();
        for(SecretMessage message : messages){
            SecretMessage secretMessage = kingdom.getMinister().writeSecretMessage(message);
            if(secretMessage.getRecieverKingdom().obtainAllegiance(secretMessage))
                allies.add(secretMessage.getRecieverKingdom());
        }
        return allies;
    }
}
