package org.example;

import java.time.LocalTime;

public class StaticMethodExample {


    public int getNano() {
        LocalTime now = LocalTime.now();
        return now.getNano();
    }



}
