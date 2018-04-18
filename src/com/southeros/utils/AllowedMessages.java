package com.southeros.utils;

import java.util.ArrayList;
import java.util.List;

public class AllowedMessages {

    private static List<String> allowedMessages;
    
    static{
        allowedMessages = new ArrayList<>();
        populateAllowedMessages();
    }
    
    private AllowedMessages(){
        throw new IllegalStateException("Util class");
    }

    public static List<String> getAllowedMessages(){
        return allowedMessages;
    }
    
    public static String getMessageAtIndex(int index){
        if(index>=0 && index<allowedMessages.size())
            return allowedMessages.get(index);
        return "None";
    }
    
    private static void populateAllowedMessages(){
        allowedMessages.add("Summer is coming");
        allowedMessages.add("a1d22n333a4444p");
        allowedMessages.add("oaaawaala");
        allowedMessages.add("zmzmzmzaztzozh");
        allowedMessages.add("Go risk it all");
        allowedMessages.add("Let's swing the sword together");
        allowedMessages.add("Die or play the tame of thrones");
        allowedMessages.add("Ahoy! Fight for me with men and money");
        allowedMessages.add("Drag on Martin!");
        allowedMessages.add("When you play the tame of thrones you win or you die.");
        allowedMessages.add("What could we say to the Lord of Death? Game on?");
        allowedMessages.add("Turn us away and we will burn you first");
        allowedMessages.add("Death is so terribly final while life is full of possibilities.");
        allowedMessages.add("You Win or You Die");
        allowedMessages.add("His watch is Ended");
        allowedMessages.add("Sphinx of black quartz judge my dozen vows");
        allowedMessages.add("Fear cuts deeper than swords My Lord.");
        allowedMessages.add("Different roads sometimes lead to the same castle.");
        allowedMessages.add("A DRAGON IS NOT A SLAVE.");
        allowedMessages.add("Do not waste paper");
        allowedMessages.add("Go ring all the bells");
        allowedMessages.add("Crazy Fredrick bought many very exquisite pearl emerald and diamond jewels.");
        allowedMessages.add("The quick brown fox jumps over a lazy dog multiple times.");
        allowedMessages.add("We promptly judged antique ivory buckles for the next prize.");
        allowedMessages.add("Walar Morghulis: All men must die.");
    }
}
