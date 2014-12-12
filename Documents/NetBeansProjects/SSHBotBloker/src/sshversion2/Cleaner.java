/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sshversion2;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import static sshversion2.BlockedIP.ipAndTime;

/**
 *
 * @author INS
 */
public class Cleaner{
    
    
    public static void cleanHashMap(){
        Timer timer = new Timer();
         timer.schedule(new TimerTask() {
            @Override
            public void run() {
                
                if(!RegIPReader.ipAndCount.isEmpty()){
                    RegIPReader.ipAndCount = new HashMap<String,Integer>();
                    System.out.println("Hashmap cleaned...!");
                }
            }
        },15000,15000);
        
    }
}
