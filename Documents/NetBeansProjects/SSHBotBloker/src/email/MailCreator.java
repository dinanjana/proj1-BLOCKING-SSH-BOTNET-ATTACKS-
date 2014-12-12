package email;

//package emailSender;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class MailCreator{

    public String getemail_body () {
        String email_body ;
        HashMap<String, String> emailbody = new HashMap<String, String>();

        email_body = "";

        String file = "C:\\Users\\win 8\\Documents\\NetBeansProjects\\SSHBotBloker\\src\\gmapWithJScript\\Locations.js.txt";
        String pattern1 = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
        String pattern2 = "([0-1]?\\d|2[0-3]):([0-5]?\\d):([0-5]?\\d)";
        Pattern pat1 = Pattern.compile(pattern1);
        Pattern pat2 = Pattern.compile(pattern2);

            try { 
                FileReader fileRd = new FileReader(file); 
                BufferedReader bufferRd = new BufferedReader(fileRd);
                String line = null; 
                while( (line = bufferRd.readLine()) != null) { 

                    Matcher m1 = pat1.matcher(line);
                    Matcher m2 = pat2.matcher(line);
                    //System.out.println(m1.group());

                    if(m1.find() && m2.find()){

                        if(emailbody.containsKey(m1.group()) != true){

                            emailbody.put(m1.group(), m2.group());
                            //System.out.println(m2.group());

                        }


                    }
                }
                fileRd.close();
                bufferRd.close();

            } catch (FileNotFoundException x) { 
                System.out.println("Make sure " + file + " is also here!");
                System.exit(-1);
            } catch (IOException x) { 
                System.out.println(x);
                System.exit(-1);
            }
            for (Map.Entry<String, String> entry : emailbody.entrySet()) {
                    email_body = email_body + "\nIP: " + entry.getKey() +" Time: "+ entry.getValue();

            }

            email_body = email_body + "\n\t\t\tRegards,\n\t\t\tssh4 group.";

            return email_body;
        }

}
    


    




