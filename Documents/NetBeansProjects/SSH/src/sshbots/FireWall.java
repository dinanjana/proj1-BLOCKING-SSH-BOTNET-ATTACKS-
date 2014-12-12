/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sshbots;

/**
 *
 * @author win 8
 */
public class FireWall {

public static void Block_UnblockIP(String ip , boolean d){
            String ip_localhost = "127.0.0.1";
                if ( d == true ){

                        System.out.println("IP Address blocked : " + ip);
                        System.out.println("\t\tsudo ufw deny from "+ ip);
                        //	Block IP Address in Ubuntu
                        //	Process Ubuntu_Block_IP = Runtime.getRuntime().exec("sudo ufw deny from "+ ip);
                        //	BufferedReader stdInputp = new BufferedReader(new InputStreamReader(Ubuntu_Block_IP.getInputStream()));	// Get Output
                        //	BufferedReader stdErrorp = new BufferedReader(new InputStreamReader(Ubuntu_Block_IP.getErrorStream()));	// Get Error
                }else{

                        System.out.println("IP Address unblocked : " + ip);
                        System.out.println("\t\tsudo ufw allow from "+ ip);
                        //	Unblock IP Address in Ubuntu
                        //	Process Ubuntu_Unblock_IP = Runtime.getRuntime().exec("sudo ufw allow from "+ ip);
                        //	BufferedReader stdInputp = new BufferedReader(new InputStreamReader(Ubuntu_Unblock_IP.getInputStream()));	// Get Output
                        //	BufferedReader stdErrorp = new BufferedReader(new InputStreamReader(Ubuntu_Unblock_IP.getErrorStream()));	// Get Error
                }
	}
    
}
