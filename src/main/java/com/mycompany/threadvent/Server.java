package com.mycompany.threadvent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Studente
 */
public class Server {
    
    ServerSocket ss;                                             //
    Socket so;                                                   //
    BufferedWriter bw;                                           //
    BufferedReader br;                                           //
    CountDown cd;
    
            public Server(int porta)
            {
                try 
                {
                    ss= new ServerSocket(porta);                //
                    System.out.println("server avviato e in ascolto");    //
                    ss.setSoTimeout(3000);  //
                    cd = new CountDown();
                    cd.start();
                    
                }
                catch (IOException ex)
                {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            public void ascolto()
            {
                try {
                    so = ss.accept();                             //
                    System.out.println("connessione stabilita");  //
                    br = new BufferedReader(new InputStreamReader(so.getInputStream()));  //
                    bw = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));//
                    }
                catch (IOException ex)
                {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            public void scrivi(String messaggio)
            {
        try {
            bw.write(messaggio+"\n");        //
            bw.flush();                 //
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
                
            }
            
            
            public String leggi()
            {
                String messaggioRitorno="";
            try
            {
                messaggioRitorno = br.readLine();
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
                return messaggioRitorno;
            }
}
   