package com.southeros.utils;

import java.util.Random;

public class SoutherosUtils {
    private SoutherosUtils(){
        throw new IllegalStateException("Util class");
    }

    public static int getRandomNumber(int bound){
        return (new Random()).nextInt(bound);
    }
}
