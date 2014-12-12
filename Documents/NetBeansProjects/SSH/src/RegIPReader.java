/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author INS
 */
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import SSH.BlockedIP;

public class RegIPReader {
    
    public static HashMap<String, Integer> ipAndCount = new HashMap<String, Integer>();
    
    public static void readIP(String fileName) {
        BlockedIP blockList = new BlockedIP();

        String pattern = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

        Pattern pat = Pattern.compile(pattern);

        try {
            FileReader fileRd = new FileReader(fileName);

            BufferedReader bufferRd = new BufferedReader(fileRd);

            String line = null;

            while (((line = bufferRd.readLine()) != null)) {

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
                            ipAndCount.remove(m.group());
                        }
                    }else{
                        ipAndCount.put(m.group(), 1);
                    }

                }
                
            }
            System.out.println(ipAndCount);
            fileRd.close();

            bufferRd.close();
            

        } catch (FileNotFoundException x) {

            System.out.println("Log file can not be found");

            System.exit(-1);
        } catch (IOException x) {

            System.out.println(x);

            System.exit(-1);
        }
    }
     
     public static void main(String[] args) {
        String fileName = fileName = "C:\\Users\\INS\\Desktop\\java\\SSHBots\\src\\sshbots\\auth.log";
         RegIPReader.readIP(fileName);
    }
}
