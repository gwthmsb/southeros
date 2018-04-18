package com.southeros.domain.model;

import java.util.Set;

import com.southeros.domain.model.interfaces.Kingdom;
import com.southeros.enums.Kingdoms;

public class SoutherosRuler {
    private Kingdom ruler;
    
    public SoutherosRuler(Kingdom ruler){
        this.ruler = ruler;
    }

    public Kingdoms getRuler() {
        return ruler.getKingdom();
    }

    public void setRuler(Kingdom ruler) {
        this.ruler = ruler;
    }

    public Set<Kingdom> getAllies() {
        return ruler.getAllies();
    }
}
