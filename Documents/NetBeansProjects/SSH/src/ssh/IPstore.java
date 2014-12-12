/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ssh;

/**
 *
 * @author win 8
 */
public class IPstore {
    
    public String IP;
    private int count;

   
    
    public IPstore(String IP){
    
        this.IP = IP;
    };
    
   
    public void setCount(int a){
    
        count = a;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }
    
                          //For testing purposes only
    @Override
        public String toString() {
            return IP;
        }
}
