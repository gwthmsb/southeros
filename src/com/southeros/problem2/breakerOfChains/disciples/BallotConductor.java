package com.southeros.problem2.breakerOfChains.disciples;

import java.util.List;
import java.util.Set;

import com.southeros.domain.model.SecretMessage;
import com.southeros.domain.model.interfaces.Kingdom;
import com.southeros.enums.Kingdoms;

public class BallotConductor {

    private Porter porter;
    private BallotCounter ballotCounter;
    private List<SecretMessage> sixRandomMessages;
    
    public BallotConductor(Porter porter, Set<Kingdoms> aspirantKingdoms, List<SecretMessage> sixRandomMessage){
        this.porter = porter;
        this.sixRandomMessages = sixRandomMessage;
        this.ballotCounter = new BallotCounter(aspirantKingdoms, porter);
    }
    
    public void conductBallot(){
        this.porter.obtainAllegiance(sixRandomMessages);
        this.ballotCounter.countBallot();
    }
    
    public Set<Kingdom> findBallotLeadingKingdoms(){
        return this.ballotCounter.findBallotLeadingKingdoms();
    }
}
