/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sshversion2;

import java.io.File;

/**
 *
 * @author win 8
 */
public class CheckGeoIP {
    
    public static void main(String [] args){
    
            
            File file = new File(
                "C:\\Users\\win 8\\Documents\\NetBeansProjects\\SSH\\src\\sshversion2\\GeoLiteCity.dat");
        
            GeoIPReader ipdetails = new GeoIPReader();
             
            ipdetails.getLocation("173.244.131.28", file);
            
            
    }
    
}
