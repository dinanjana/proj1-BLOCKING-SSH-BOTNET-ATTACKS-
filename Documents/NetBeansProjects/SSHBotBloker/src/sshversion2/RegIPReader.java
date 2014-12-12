package sshversion2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author INS
 */

import email.SSLEmail;
import filewriters.LocationWriter;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegIPReader extends Thread{
    
    public static HashMap<String, Integer> ipAndCount = new HashMap<String, Integer>();
    
    public static void readIP(String fileName) {
        BlockedIP blockList = new BlockedIP();
        long size = 0;
        LocationWriter lw = new LocationWriter();
        String pattern = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

        Pattern pat = Pattern.compile(pattern);
        FileReader fileRd = null;
        BufferedReader bufferRd = null;
        
        Cleaner.cleanHashMap(); // this is clearing hashmap every 10s
        
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        
        try {
            File file = new File(fileName);
            fileRd = new FileReader(file);
            size = file.length();
            bufferRd = new BufferedReader(fileRd);

            String line = null;

            while (true) {
                if(size > file.length()){
                    //fileRd.close();
                    //bufferRd.close();
                    file = new File(fileName);
                    fileRd = new FileReader(file);
                    bufferRd = new BufferedReader(fileRd);
                    ipAndCount.clear();
                    System.out.println("file reset....!");
                }
                size = file.length();
                
                if(((line = bufferRd.readLine()) != null)){
                    Matcher m = pat.matcher(line);


                    if  (m.find() && 
                        (line.contains("error: PAM:")||
                         line.contains("Invalid user"))) {

                        if(blockList.ipAndTime.containsKey(m.group())) continue;

                        if(ipAndCount.containsKey(m.group()) == true){
                            int ipCount = ipAndCount.get(m.group());
                            ipAndCount.replace(m.group(), ++ipCount);
                            if(ipCount==5){
                                System.out.println("blocked "+m.group());
                                blockList.ipAndTime.put(m.group(), System.currentTimeMillis()+4000);
				FireWall.Block_UnblockIP(m.group() , true);
                                lw.writeLocations(m.group());
                                ipAndCount.remove(m.group());
                            }
                        }else{
                            ipAndCount.put(m.group(), 1);
                        }

                    }

                }else{
                    System.out.println(ipAndCount);
                    Thread.sleep(5000);
                    
                }
                
                if(dateFormat.format(date).equals("00:00:00")){
                    new SSLEmail().sendEmail();
                    lw.eraseFile();
                }              
            }

        } catch (FileNotFoundException x) {

            System.out.println("Log file can not be found");

            System.exit(-1);
        } catch (IOException x) {

            System.out.println(x);

            System.exit(-1);
        } catch (InterruptedException ex) {
            Logger.getLogger(RegIPReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
}
