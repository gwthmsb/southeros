package com.southeros.decorator;

import java.util.Map;

import com.southeros.domain.model.interfaces.Kingdom;
import com.southeros.domain.model.kingdom.BallotKingdom;
import com.southeros.domain.model.kingdom.RulerAspirantKingdom;
import com.southeros.enums.Kingdoms;

public class KingdomDecorator {

    public static RulerAspirantKingdom applyRulerAspirantDecorator(Kingdom kingdom){
        return new RulerAspirantKingdom(kingdom);
    }
    
    public static BallotKingdom applyBallotDecorator(Kingdom kingdom, Map<Kingdoms, Kingdom> kingdoms){
        return new BallotKingdom(kingdom, kingdoms);
    }
}
