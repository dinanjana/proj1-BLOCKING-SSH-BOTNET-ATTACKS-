/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package email;

import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
 
public class SSLEmail {
 
    /**
       Outgoing Mail (SMTP) Server
       requires TLS or SSL: smtp.gmail.com (use authentication)
       Use Authentication: Yes
       Port for SSL: 465
     */
    
    private String toEmail = "gayanboom@gmail.com"; // can be any email id 

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }
    
    
    
    public void sendEmail(){
        final String fromEmail = "gayanboom@gmail.com"; //requires valid gmail id
        final String password = "92813@SUNSILK&shampoo0"; // correct password for gmail id
        
         
        //System.out.println("SSLEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        props.put("mail.smtp.port", "465"); //SMTP Port
         
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
         
        Session session = Session.getDefaultInstance(props, auth);
        //System.out.println("Session created");
        String subj = "Dear administrator, These are the locations of attacks for last 24 hours.";
            EmailUtil.sendEmail(session, toEmail,subj, new MailCreator().getemail_body());
 
            //EmailUtil.sendAttachmentEmail(session, toEmail,"SSLEmail Testing Subject with Attachment", "SSLEmail Testing Body with Attachment");
 
            //EmailUtil.sendImageEmail(session, toEmail,"SSLEmail Testing Subject with Image", "SSLEmail Testing Body with Image");
 
    }
 
}