package com.southeros.data;

import java.util.HashSet;
import java.util.Set;

import com.southeros.decorator.KingdomDecorator;
import com.southeros.domain.model.interfaces.Kingdom;
import com.southeros.domain.model.kingdom.KingdomFactory;
import com.southeros.enums.Kingdoms;
import com.southeros.utils.Names;

public class KingdomData {

    public static Set<Kingdom> kingdoms = new HashSet<>();
    public static Set<Kingdom> alligiancePledgedKingdoms = new HashSet<>();
    public static Set<Kingdom> aspirantKingdoms = new HashSet<>();
    
    static{
        populateKingdoms();
        populateAllegiancePledgedKingdoms();
        populateAspirantKingdoms();
    }
    
    public Set<Kingdom> getKingdomsData(){
        return kingdoms;
    }
    
    public Set<Kingdom> getAllegiancePledgedKingdoms(){
        return alligiancePledgedKingdoms;
    }
    
    public Set<Kingdom> getAspirantKingdoms(){
        return aspirantKingdoms;
    }
    
    static void populateKingdoms(){
        kingdoms.add(KingdomFactory.getKingdom(Names.AIR));
        kingdoms.add(KingdomFactory.getKingdom(Names.LAND));
        kingdoms.add(KingdomFactory.getKingdom(Names.WATER));
        kingdoms.add(KingdomFactory.getKingdom(Names.SPACE));
        kingdoms.add(KingdomFactory.getKingdom(Names.ICE));
        kingdoms.add(KingdomFactory.getKingdom(Names.FIRE));
    }
    
    static void populateAllegiancePledgedKingdoms(){
        Kingdom air = KingdomFactory.getKingdom(Names.AIR);
        Kingdom land = KingdomFactory.getKingdom(Names.LAND);
        Kingdom ice = KingdomFactory.getKingdom(Names.ICE);
        Kingdom fire = KingdomFactory.getKingdom(Names.FIRE);
        
        Kingdom space = KingdomFactory.getKingdom(Kingdoms.SPACE);
        Kingdom water = KingdomFactory.getKingdom(Kingdoms.SPACE);
        
        air.setAllegiancePledged(space);
        land.setAllegiancePledged(space);
        ice.setAllegiancePledged(water);
        fire.setAllegiancePledged(space);
        
        alligiancePledgedKingdoms.add(air);
        alligiancePledgedKingdoms.add(land);
        alligiancePledgedKingdoms.add(ice);
        alligiancePledgedKingdoms.add(fire);
    }
    
    static void populateAspirantKingdoms(){
        Kingdom SPACE = KingdomDecorator.applyRulerAspirantDecorator(KingdomFactory.getKingdom(Kingdoms.SPACE));
        Kingdom WATER = KingdomDecorator.applyRulerAspirantDecorator(KingdomFactory.getKingdom(Kingdoms.WATER));
        
        aspirantKingdoms.add(SPACE);
        aspirantKingdoms.add(WATER);
    }
}
