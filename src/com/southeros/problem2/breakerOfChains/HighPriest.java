package com.southeros.problem2.breakerOfChains;

import java.util.List;
import java.util.Set;

import com.southeros.domain.model.SecretMessage;
import com.southeros.domain.model.SoutherosRuler;
import com.southeros.domain.model.interfaces.Kingdom;
import com.southeros.domain.model.kingdom.KingdomFactory;
import com.southeros.enums.Kingdoms;
import com.southeros.problem2.breakerOfChains.disciples.BallotConductor;
import com.southeros.problem2.breakerOfChains.disciples.Porter;
import com.southeros.utils.KingdomsAndKings;
import com.southeros.utils.MessageProvider;

public class HighPriest {

    private Set<Kingdoms> aspirantKingdoms;
    private Porter porter;
    private SoutherosRuler southerosRuler;
    private int count = 1;
    
    public HighPriest(Set<Kingdoms> aspirantKindomNames){
        this.aspirantKingdoms = aspirantKindomNames;
        this.porter = new Porter(aspirantKindomNames);
        this.southerosRuler = new SoutherosRuler(KingdomFactory.getKingdom(Kingdoms.NONE));
    }
    
    public void conductBallot(){
        if(!aspirantKingdoms.isEmpty()){
            this.porter.prepareForBallot();
            startBallot();
        }else{
            System.out.println("No Kingdom is aspirant of poisonous POWER. Finally peace in Southeros");
        }
    }
    
    private void startBallot(){
        this.porter.conveyKingdomsToAcceptAllegiance();
        List<SecretMessage> secretMessages = this.porter.conveySendMessage();
        List<SecretMessage> sixRandomMessages = MessageProvider.pickSecretMessagesRandomly(secretMessages, 6);
        
        BallotConductor ballotConductor = new BallotConductor(porter, aspirantKingdoms, sixRandomMessages);
        ballotConductor.conductBallot();
        Set<Kingdom> ballotLeadingKingdoms = ballotConductor.findBallotLeadingKingdoms();

        printResultsAfterBallot(ballotLeadingKingdoms);
        
        if(ballotLeadingKingdoms.isEmpty()){
            startBallot();
        }else if(ballotLeadingKingdoms.size() >1){
            this.aspirantKingdoms.removeAll(ballotLeadingKingdoms);
            
            aspirantKingdoms.forEach(kingdom -> porter.conveyHighPriestMessageToStopWar(kingdom));
            
            this.aspirantKingdoms.clear();
            ballotLeadingKingdoms.forEach(k -> {
                this.aspirantKingdoms.add(k.getKingdom());
            });
            startBallot();
        }else{
            for(Kingdom k : ballotLeadingKingdoms){
                if(k.getAllies().isEmpty())
                    startBallot();
                corronateKing(k);
                break;
            }
        }
    }
    
    private void printResultsAfterBallot(Set<Kingdom> ballotLeadingKingdoms){
        System.out.println("Results after Ballot round : "+count++);
        ballotLeadingKingdoms.forEach(kingdom -> {
            System.out.println("Allies for "+kingdom.getKingdom() +" : "+kingdom.getAllies().size());
        });
    }
    
    private void corronateKing(Kingdom kingdom){
        this.southerosRuler.setRuler(kingdom);
    }
    
    public Kingdoms getKingOfSoutheros(){
        return southerosRuler.getRuler();
    }
    
    public String getAlliesOfRuler(){
        if(!KingdomsAndKings.getKing(southerosRuler.getRuler()).equals(KingdomsAndKings.getKing(Kingdoms.NONE))){
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
}
