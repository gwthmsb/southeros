package com.southeros.domain.model.kingdom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.southeros.domain.model.SecretMessage;
import com.southeros.domain.model.interfaces.Ballot;
import com.southeros.domain.model.interfaces.Kingdom;
import com.southeros.enums.Kingdoms;
import com.southeros.utils.MessageProvider;

public class BallotKingdom extends KingdomAbstract implements Ballot{

    private Map<Kingdoms, Kingdom> kingdoms;
    public BallotKingdom(Kingdom kingdom, Map<Kingdoms, Kingdom> kingdoms){
        super(kingdom);
        this.kingdoms = kingdoms;
    }
    
    @Override
    public void sendMessagesToKingdom(){
        List<SecretMessage> secretMessages = new ArrayList<>(); 
        for(Kingdoms kingdomName: Kingdoms.values()){
            if(!kingdomName.equals(this.getKingdom()) && !kingdomName.equals(Kingdoms.NONE)){
                Kingdom receipientKingdom = kingdoms.get(kingdomName);
                String message = MessageProvider.getRandomMessage();
                secretMessages.add(this.getKingdomObject().getMinister().writeSecretMessage(message, receipientKingdom));
            }
        }
        getKingdomObject().setSecretMessages(secretMessages);
    }
}
