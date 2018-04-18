package com.southeros.domain.model.interfaces;

import java.util.List;
import java.util.Set;

import com.southeros.domain.model.Minister;
import com.southeros.domain.model.SecretMessage;
import com.southeros.enums.Kingdoms;

public interface Kingdom {
    public Kingdoms getKingdom();
    public String getKing();
    public Minister getMinister() ;
    public String getEmblem();
    public Kingdom getAllegiancePledged() ;
    public Set<Kingdom> getAllies();
    public void setAllies(Set<Kingdom> allies);
    public void setSecretMessages(List<SecretMessage> secretMessage);
    public List<SecretMessage> getSecretMessages();
    public void setAllegiancePledged(Kingdom allegiancePledged);
    public boolean obtainAllegiance(SecretMessage message);
    public void sendMessagesToKingdom();
}
