/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package sshbots;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.parser.TokenType;
/**
 *
 * @author INS
 */
public class BlockedIP extends Thread{
    public static HashMap<String, Long> ipAndTime = new HashMap<String, Long>();
    
    private Timer timer = new Timer();

    /*{
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(""+System.currentTimeMillis());
            }
        }, 10000,10000);
    
    
    
    }*/
    
    {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Unblocked ip");
                String ip = null;
                for(String currentKey : ipAndTime.keySet()){
                    if(ip != null) ipAndTime.remove(ip);
                    ip = null;
                    Long currTime = ipAndTime.get(currentKey);
                    if(currTime <= System.currentTimeMillis()){
                        ip = currentKey;
                        System.out.println(""+currentKey);
                    }
                }
                timer.cancel();
            }
        }, 5000);
    }
    
}
