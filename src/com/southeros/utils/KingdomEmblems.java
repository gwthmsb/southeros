package com.southeros.utils;

import java.util.EnumMap;
import java.util.Map;

import com.southeros.enums.Kingdoms;

public class KingdomEmblems {

    private static Map<Kingdoms, String> kingdomEmblems = new EnumMap<Kingdoms, String>(Kingdoms.class);
    
    static{
        kingdomEmblems.put(Kingdoms.LAND, Names.PANDA);
        kingdomEmblems.put(Kingdoms.AIR, Names.OWL);
        kingdomEmblems.put(Kingdoms.FIRE, Names.DRAGON);
        kingdomEmblems.put(Kingdoms.WATER, Names.OCTOPUS);
        kingdomEmblems.put(Kingdoms.ICE, Names.MAMMOTH);
        kingdomEmblems.put(Kingdoms.SPACE, Names.GORILLA);
        kingdomEmblems.put(Kingdoms.NONE, Names.NOMANSLAND);
    }
    
    private KingdomEmblems(){
        throw new IllegalStateException("Util class");
    }
    
    public static String getEmblem(Kingdoms kingdom){
        return kingdomEmblems.get(kingdom);
    }
}
