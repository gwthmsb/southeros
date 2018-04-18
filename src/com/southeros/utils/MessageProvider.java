package com.southeros.utils;

import java.util.ArrayList;
import java.util.List;

import com.southeros.domain.model.SecretMessage;

public class MessageProvider {
    
    private MessageProvider(){
        throw new IllegalStateException("Static class");
    }

    public static String getRandomMessage(){
        int randomNumber = SoutherosUtils.getRandomNumber(AllowedMessages.getAllowedMessages().size());
        return AllowedMessages.getMessageAtIndex(randomNumber);
    }
    
    public static final List<SecretMessage> pickSecretMessagesRandomly(List<SecretMessage> secretMessages, int limit){
        List<SecretMessage> selectedMessages = new ArrayList<>();
        List<Integer> randomIndex = pickMessagesIndexRandomly(secretMessages.size(), limit);
        
        randomIndex.forEach(index -> selectedMessages.add(secretMessages.get(index)));
        
        return selectedMessages;
    }
    
    public static final List<Integer> pickMessagesIndexRandomly(int bound, int limit){
        List<Integer> randomIndex = new ArrayList<>();
        if(bound<6){
            for(int i=0;i<bound;i++){
                randomIndex.add(i);
            }
        }else{
            while(randomIndex.size()<limit && randomIndex.size()!=bound){
                int index = SoutherosUtils.getRandomNumber(bound);
                if(!randomIndex.contains(index))
                        randomIndex.add(index);
            }
        }
        return randomIndex;
    }
}
