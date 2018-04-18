package com.southeros.domain.model.kingdom;

import com.southeros.domain.model.interfaces.Kingdom;
import com.southeros.enums.Kingdoms;
import com.southeros.utils.Names;

public class KingdomFactory {
    
    private KingdomFactory(){
        throw new IllegalStateException("Factory class");
    }
    
    public static Kingdom getKingdom(String kingdomName){
        Kingdom kingdom;
        switch(kingdomName){
        case Names.AIR:
            kingdom = new KingdomObject(Kingdoms.AIR);
            break;
        case Names.ICE:
            kingdom = new KingdomObject(Kingdoms.ICE);
            break;
        case Names.FIRE:
            kingdom = new KingdomObject(Kingdoms.FIRE);
            break;
        case Names.WATER:
            kingdom = new KingdomObject(Kingdoms.WATER);
            break;
        case Names.LAND:
            kingdom = new KingdomObject(Kingdoms.LAND);
            break;
        case Names.SPACE:
            kingdom = new KingdomObject(Kingdoms.SPACE);
            break;
        default :
            kingdom = new KingdomObject(Kingdoms.NONE);
        }
        return kingdom;
    }
    
    
    public static Kingdom getKingdom(Kingdoms kingdomName){
        return new KingdomObject(kingdomName);
    }
}
