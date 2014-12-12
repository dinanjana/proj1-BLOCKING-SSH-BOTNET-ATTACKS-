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
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.*;

public class LogReader {

    public static void main(String[] args) {

        int count = 0;

        ArrayList<IPstore> IParray = new ArrayList<>();

        String pattern = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

        Pattern pat = Pattern.compile(pattern);

        String fileName;

        fileName = "C:\\Users\\win 8\\Documents\\NetBeansProjects\\SSH\\src\\ssh\\auth.log";

        try {
            FileReader fileRd = new FileReader(fileName);

            BufferedReader bufferRd = new BufferedReader(fileRd);

            String line = null;

            while (((line = bufferRd.readLine()) != null)) {

                Matcher m = pat.matcher(line);
               
                 IPstore a;
                 
                if  (m.find() && 
                    (line.contains("error: PAM:")||
                     line.contains("Invalid user"))) {
                    
                    //b.setCount(count);
                    a = new IPstore(m.group());
                   // b = new IPstore();
                    
                    
                    IParray.add(a);

                    System.out.println("Found IP: " + m.group());

                    count = 0;

                }
                
               
            }
            fileRd.close();

            bufferRd.close();
            
            Collections.sort(IParray, new Comparator<IPstore>() {
                @Override
                public int compare(IPstore  IP1, IPstore IP2)
                {

                    return  IP1.IP.compareTo(IP2.IP);
                    
                }
            });
            
            System.out.println(IParray);

        } catch (FileNotFoundException x) {

            System.out.println("Log file can not be found");

            System.exit(-1);
        } catch (IOException x) {

            System.out.println(x);

            System.exit(-1);
        }
    }

}
