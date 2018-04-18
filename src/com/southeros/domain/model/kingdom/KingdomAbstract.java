package com.southeros.domain.model.kingdom;

import java.util.List;
import java.util.Set;

import com.southeros.domain.model.Minister;
import com.southeros.domain.model.SecretMessage;
import com.southeros.domain.model.interfaces.Kingdom;
import com.southeros.enums.Kingdoms;

public abstract class KingdomAbstract implements Kingdom{
    private Kingdom kingdom;
    
    KingdomAbstract(Kingdom kingdom) {
        this.kingdom = kingdom;
    }

    public Kingdom getKingdomObject(){
        return kingdom;
    }
    
    @Override
    public void setSecretMessages(List<SecretMessage> secretMessage){
        this.kingdom.setSecretMessages(secretMessage); 
    }
    
    @Override
    public boolean obtainAllegiance(SecretMessage message) {
        return this.kingdom.obtainAllegiance(message);
    }
    
    @Override
    public Kingdoms getKingdom() {
        return kingdom.getKingdom();
    }
    @Override
    public String getKing() {
        return kingdom.getKing();
    }
    @Override
    public Minister getMinister() {
        return kingdom.getMinister();
    }
    @Override
    public String getEmblem(){
        return kingdom.getEmblem();
    }
    @Override
    public Kingdom getAllegiancePledged() {
        return kingdom.getAllegiancePledged();
    }
    @Override
    public Set<Kingdom> getAllies() {
        return kingdom.getAllies();
    }
    @Override
    public void setAllies(Set<Kingdom> allies){
        kingdom.setAllies(allies);
    }
    @Override
    public void setAllegiancePledged(Kingdom allegiancePledged) {
        kingdom.setAllegiancePledged(allegiancePledged);
    }
    @Override
    public void sendMessagesToKingdom() {
        kingdom.sendMessagesToKingdom();
    }
    @Override
    public List<SecretMessage> getSecretMessages(){
        return kingdom.getSecretMessages();
    }
}
