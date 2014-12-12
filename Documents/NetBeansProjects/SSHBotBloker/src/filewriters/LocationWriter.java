/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filewriters;

import iplocation.GeoIPReader;
import iplocation.ServerLocation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INS
 */
public class LocationWriter {
    
    private File file;
    private FileWriter fw;
    private BufferedWriter bf;
    private String content = "";
    private String fileName = "C:\\Users\\win 8\\Documents\\NetBeansProjects\\SSHBotBloker\\src\\gmapWithJScript\\Locations.js";
    
    public void writeLocations(String ip){
        try {
            if(content.equals("")){
                readFile();
                if(content.equals("")) content = "var locations = [";
            }
            //System.out.println(""+content);

            file = new File(fileName);
            fw = new FileWriter(file);

            GeoIPReader gip = new GeoIPReader();
            ServerLocation sl;
            sl = gip.getLocation(ip);
            String description;
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            
            String subDesc = "['<h4>Country : " + sl.getCountryName() + ",  IP : " + ip + ",  Blocked Date&Time : "+ dateFormat.format(date) + "</h4>',";
            if(content.contains("]")){
                description = "," + subDesc +sl.getLatitude()+ "," +sl.getLongtiude() + "]];";
            }else{
                description = subDesc + sl.getLatitude()+ "," + sl.getLongtiude() + "]];";
            }
                
            
            String [] newStr = content.split("];");
            content = newStr[0] + "\n" + description;

            bf = new BufferedWriter(fw);
            bf.write(content);
            bf.close();
        } catch (IOException ex) {
            Logger.getLogger(LocationWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void readFile(){
        //String fileName = "C:\\Users\\INS\\Desktop\\java\\SSHBotBloker\\src\\gmapWithJScript\\Locations.js";                 // file 
	try { 
	    FileReader fileRd = new FileReader(fileName); 
	    BufferedReader bufferRd = new BufferedReader(fileRd);
	    String line = null; 
	    while( (line = bufferRd.readLine()) != null) { 
		//System.out.println(line);
                content = content + line + "\n";
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
    

    public void eraseFile(){
        try {
            
            file = new File(fileName);
            fw = new FileWriter(file);
            bf = new BufferedWriter(fw);
            bf.write("");
            
        } catch (IOException ex) {
            Logger.getLogger(LocationWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}




/*
var locations = [
      ['<h4>Bondi Beach</h4>', -33.890542, 151.274856],
      ['<h4>Coogee Beach</h4>', -33.923036, 151.259052],
      ['<h4>Cronulla Beach</h4>', -34.028249, 151.157507],
      ['<h4>Manly Beach</h4>', -33.80010128657071, 151.28747820854187],
      ['<h4>Maroubra Beach</h4>', -33.950198, 151.259302]
    ];
*/