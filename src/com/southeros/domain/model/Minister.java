package com.southeros.domain.model;

import com.southeros.domain.model.interfaces.Kingdom;
import com.southeros.utils.Names;

public class Minister {

    private Kingdom kingdom;
    
    public Minister(Kingdom kingdom){
        this.kingdom=kingdom;
    }
    
    public boolean decodeMessage(String secretMessage){
        boolean validSecretMessage=false;
        if(!Names.NOMANSLAND.equals(kingdom.getEmblem())){
            validSecretMessage=true;
            String message = secretMessage.toLowerCase();
            String space = " ";
            char[] emblemChar = kingdom.getEmblem().toCharArray();
            for(char c : emblemChar){
                if(message.contains(Character.toString(c))){
                    message = message.replaceFirst(Character.toString(c), space);
                }else{
                    validSecretMessage = false;
                    break;
                }
            }
        }
        return validSecretMessage;
    }
    
    public SecretMessage writeSecretMessage(SecretMessage secretMessage){
        secretMessage.setSenderKingdom(kingdom);
        return secretMessage;
    }
    
    public SecretMessage writeSecretMessage(String message, Kingdom reciepientKingdom){
        SecretMessage secretMessage = new SecretMessage();
        secretMessage.setRecieverKingdom(reciepientKingdom);
        secretMessage.setSenderKingdom(kingdom);
        secretMessage.setSecretMessage(message); 
        return secretMessage;
    }
}
