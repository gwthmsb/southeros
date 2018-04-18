package com.southeros.domain.model;

import com.southeros.domain.model.interfaces.Kingdom;

public class SecretMessage {

    private Kingdom senderKingdom;
    private Kingdom recieverKingdom;
    private String secretMessage;
    
    public Kingdom getSenderKingdom() {
        return senderKingdom;
    }
    public void setSenderKingdom(Kingdom senderKingdom) {
        this.senderKingdom = senderKingdom;
    }
    public Kingdom getRecieverKingdom() {
        return recieverKingdom;
    }
    public void setRecieverKingdom(Kingdom recieverKingdom) {
        this.recieverKingdom = recieverKingdom;
    }
    public String getSecretMessage() {
        return secretMessage;
    }
    public void setSecretMessage(String secretMessage) {
        this.secretMessage = secretMessage;
    }
    
    public String toString(){
        return senderKingdom.getKingdom() +" "+ recieverKingdom.getKingdom() +" "+ secretMessage;
    }
}
