package com.southeros.problem2.breakerOfChains.disciples;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import com.southeros.domain.model.interfaces.Kingdom;
import com.southeros.enums.Kingdoms;

public class BallotCounter {

    private Set<Kingdoms> aspirantKingdoms;
    private Porter porter;
    private Map<Integer, Set<Kingdom>> allies ;
    private Set<Kingdom> ballotLeadingKingdoms;
    
    public BallotCounter(Set<Kingdoms> aspirantKingdoms, Porter porter){
        this.aspirantKingdoms = aspirantKingdoms;
        this.porter = porter;
        this.allies = new HashMap<>();
        this.ballotLeadingKingdoms = new HashSet<>();
    }
    
    public void countBallot(){
        int maxNoOfAllies =0;
        for(Kingdoms kingdomName : aspirantKingdoms){
            Kingdom kingdom = porter.getKingdomRepresent(kingdomName);
            int size = kingdom.getAllies().size();
            if(maxNoOfAllies<=size){
                maxNoOfAllies = size;
                Set<Kingdom> aspirantKingdomsSet = allies.get(maxNoOfAllies);
                if(aspirantKingdomsSet==null){
                    aspirantKingdomsSet = new LinkedHashSet<>();
                    allies.put(maxNoOfAllies, aspirantKingdomsSet);
                }
                aspirantKingdomsSet.add(kingdom);
            }
        }
        if(allies.keySet().contains(maxNoOfAllies))
            ballotLeadingKingdoms = allies.get(maxNoOfAllies);
    }
    
    public Set<Kingdom> findBallotLeadingKingdoms(){
        return ballotLeadingKingdoms;
    }
}
