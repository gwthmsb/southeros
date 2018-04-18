package com.southeros.domain.model.kingdom;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.southeros.domain.model.King;
import com.southeros.domain.model.Minister;
import com.southeros.domain.model.SecretMessage;
import com.southeros.domain.model.interfaces.Kingdom;
import com.southeros.enums.Kingdoms;
import com.southeros.utils.KingdomEmblems;

public class KingdomObject implements Kingdom{

    private Kingdoms kingdom;
    private Minister minister;
    private King king;
    private String emblem;
    private Kingdom allegiancePledged;
    private Set<Kingdom> allies;
    private List<SecretMessage> secterMessages;
    
    KingdomObject(){}
    
    KingdomObject(Kingdoms kingdom){
        this.kingdom = kingdom;
        this.emblem = KingdomEmblems.getEmblem(kingdom);
        this.king = new King(this);
        this.minister = new Minister(this);
        this.allies = new LinkedHashSet<>();
        this.secterMessages = new ArrayList<>();
    }
    
    public Kingdoms getKingdom() {
        return kingdom;
    }
    public String getKing() {
        return king.getKing();
    }
    public Minister getMinister() {
        return minister;
    }
    public String getEmblem(){
        return this.emblem;
    }
    public Kingdom getAllegiancePledged() {
        return allegiancePledged;
    }
    public Set<Kingdom> getAllies() {
        return allies;
    }
    public void setAllies(Set<Kingdom> allies){
        this.allies = allies;
    }
    public void setSecretMessages(List<SecretMessage> secretMessage){
        this.secterMessages = secretMessage; 
    }
    public void setAllegiancePledged(Kingdom allegiancePledged) {
        this.allegiancePledged = allegiancePledged;
    }
    
    public boolean obtainAllegiance(SecretMessage message){
        if(this.allegiancePledged==null && 
                minister.decodeMessage(message.getSecretMessage())){
            this.allegiancePledged = message.getSenderKingdom();
            return true;
        }
        return false;
    }
    
    public void sendMessagesToKingdom(){
        allies.addAll(king.sendMessageToKingdom(secterMessages));
    }
    
    public List<SecretMessage> getSecretMessages(){
        return this.secterMessages;
    }
}
