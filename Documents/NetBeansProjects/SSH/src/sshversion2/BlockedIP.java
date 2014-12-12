/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sshversion2;


import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author INS
 */
public class BlockedIP extends Thread{
    public static HashMap<String, Long> ipAndTime = new HashMap<String, Long>();
    
    private Timer timer = new Timer();
    
    {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                
                HashMap<String, Long> temp = new HashMap<>();
                for(String item : ipAndTime.keySet()){ 
                    System.out.println("Unblocking items : "+item);
                    FireWall.Block_UnblockIP(item, false); //newly added
                    Long currTime = ipAndTime.get(item);
                    if(currTime > System.currentTimeMillis()){
                        temp.put(item, currTime);
						
                        
                    }
                }
                ipAndTime = temp;
                temp = null;
                
            }
        }, 10000,10000);
        //System.out.println("this ends");
    }
    
}
