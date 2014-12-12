/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sshbots;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author win 8
 */
public class GeoIPStore {
    
     public static HashMap<String, String> geoIP = new HashMap<String, String>();
     
     public static void main(String [] args) { 

	String fileName = "File.csv";// please put the
                                 //link of the file 
	try { 
	    FileReader fileRd = new FileReader(fileName); 
	    BufferedReader bufferRd = new BufferedReader(fileRd);
	    String line = null; 
            int j = 1;
	    while( (line = bufferRd.readLine()) != null) { 
                String [] s = line.split(",");
                if(j != 1){
                    for(int i = 1; i < s.length ; i++){
                        if(!s[i].equals("") && i == 28){
                            System.out.println(s[i]);
                        }
                    }
                }
                j++;
	    }   
	    fileRd.close();
	    bufferRd.close();

	} catch (FileNotFoundException x) { 
	    System.out.println("Make sure " + fileName + " is also here!");
	    System.exit(-1);
	} catch (IOException x) { 
	    System.out.println(x);
	    System.exit(-1);
	} 
    }
    
    
}
