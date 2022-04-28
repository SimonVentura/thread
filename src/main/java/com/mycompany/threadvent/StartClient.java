/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.threadvent;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Studente
 */
public class StartClient  {

    public static void main(String[] args) {
        try {
            Client cli = new Client(InetAddress.getLocalHost(),2000);    //
            cli.leggi();
            cli.scrivi("hola");
            
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(StartClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
