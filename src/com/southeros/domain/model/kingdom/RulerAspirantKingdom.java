package com.southeros.domain.model.kingdom;

import com.southeros.domain.model.SecretMessage;
import com.southeros.domain.model.interfaces.Kingdom;
import com.southeros.domain.model.interfaces.RulerAspirant;

public class RulerAspirantKingdom extends KingdomAbstract implements RulerAspirant{
    
    private boolean rulerAsprirant;
    
    public RulerAspirantKingdom(Kingdom kingdom) {
        super(kingdom);
        rulerAsprirant = true;
    }
    
    @Override
    public boolean isRulerAsprirant() {
        return rulerAsprirant;
    }
    
    @Override
    public void attainEnlightenmentToStopWar(){
        this.rulerAsprirant=false;
    }
    
    @Override
    public boolean obtainAllegiance(SecretMessage message){
        if(rulerAsprirant){
            setAllegiancePledged(null);
            return false;
        } else if(getAllegiancePledged()!=null){
            return false;
        }else{
            return super.obtainAllegiance(message);
        }
    }
}
