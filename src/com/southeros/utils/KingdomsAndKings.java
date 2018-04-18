package com.southeros.utils;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import com.southeros.enums.Kingdoms;

public class KingdomsAndKings {
    private static Map<Kingdoms, String> kingdomsAndKings= new EnumMap<Kingdoms, String>(Kingdoms.class);
    private static Map<String, Kingdoms> kingsAndKingdoms = new HashMap<>();
    
    static{
        kingdomsAndKings.put(Kingdoms.LAND, Names.LAND_KING);
        kingdomsAndKings.put(Kingdoms.AIR, Names.AIR_KING);
        kingdomsAndKings.put(Kingdoms.ICE, Names.ICE_KING);
        kingdomsAndKings.put(Kingdoms.FIRE, Names.FIRE_KING);
        kingdomsAndKings.put(Kingdoms.WATER, Names.WATER_KING);
        kingdomsAndKings.put(Kingdoms.SPACE, Names.SPACE_KING);
        kingdomsAndKings.put(Kingdoms.NONE, Names.NOMANSLAND_KING);
        
        
        kingsAndKingdoms.put(Names.LAND_KING, Kingdoms.LAND);
        kingsAndKingdoms.put(Names.AIR_KING, Kingdoms.AIR);
        kingsAndKingdoms.put(Names.ICE_KING, Kingdoms.ICE);
        kingsAndKingdoms.put(Names.FIRE_KING, Kingdoms.FIRE);
        kingsAndKingdoms.put(Names.WATER_KING, Kingdoms.WATER);
        kingsAndKingdoms.put(Names.SPACE_KING, Kingdoms.SPACE);
    }
    
    private KingdomsAndKings(){
        throw new IllegalStateException("Util class");
    }
    
    public static String getKing(Kingdoms kingdom){
        return kingdomsAndKings.get(kingdom);
    }
    
    public static Kingdoms getKingdom(String king){
        return kingsAndKingdoms.get(king);
    }
}
