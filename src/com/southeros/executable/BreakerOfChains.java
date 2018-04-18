package com.southeros.executable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

import com.southeros.enums.Kingdoms;
import com.southeros.problem2.breakerOfChains.HighPriest;

public class BreakerOfChains {

    private Set<Kingdoms> aspirantKingdoms;
    private String aspirantKingdomsString;
    private HighPriest highPriest;
    
    public BreakerOfChains(String aspirantKingdomsString){
        this.aspirantKingdomsString = aspirantKingdomsString;
        this.aspirantKingdoms = new LinkedHashSet<>();
        populateAspirantKingdoms();
        this.highPriest = new HighPriest(aspirantKingdoms);
    }
    
    public static void main(String[] args){
        try{
            System.out.println("You are in middle of RULER crisis of Southeros.");
            System.out.println("Help in choosing ruler for Southeros.");
            System.out.println("Provide ruler aspirant kingdoms from Southeros kingdoms : Air, Fire, Ice, Land, Space, Water");
            System.out.println("Instruction - Use empty space in between kingdoms, Enter aspirant kingdoms in single line");
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            String aspirantKingdomsString = reader.readLine();
            
            BreakerOfChains breakerOfChains = new BreakerOfChains(aspirantKingdomsString);
            breakerOfChains.askHighPriestToStartBallot();
            System.out.println("Ruler of Southeros : "+breakerOfChains.getHighPriest().getKingOfSoutheros());
            System.out.println("Allies of Southeros : "+breakerOfChains.getHighPriest().getAlliesOfRuler());
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    private void populateAspirantKingdoms(){
        if(null!= aspirantKingdomsString && !aspirantKingdomsString.isEmpty()){
            String[] kingdoms = aspirantKingdomsString.split(" ");
            for(String kingdom : kingdoms){
                kingdom = kingdom.toLowerCase();
                switch(kingdom){
                case "air":
                    aspirantKingdoms.add(Kingdoms.AIR);
                    break;
                case "fire":
                    aspirantKingdoms.add(Kingdoms.FIRE);
                    break;
                case "land":
                    aspirantKingdoms.add(Kingdoms.LAND);
                    break;
                case "water":
                    aspirantKingdoms.add(Kingdoms.WATER);
                    break;
                case "space":
                    aspirantKingdoms.add(Kingdoms.SPACE);
                    break;
                case "ice":
                    aspirantKingdoms.add(Kingdoms.ICE);
                    break;
                default:
                    System.out.println("Valid aspirant Kingdoms are necessary for stoping war");
                    System.exit(1);
                }
            }
        }
        if(aspirantKingdoms.isEmpty()){
            System.out.println("Aspirant Kingdoms are necessary for stoping war");
            System.exit(1);
        }
    }
    
    private void askHighPriestToStartBallot(){
        this.highPriest.conductBallot();
    }
    private HighPriest getHighPriest(){
        return this.highPriest;
    }
}
