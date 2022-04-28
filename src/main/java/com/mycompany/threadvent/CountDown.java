/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.threadvent;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Studente
 */
public class CountDown extends Thread{
    public int tempo;
    
    public CountDown(int t)
    {
        this.tempo=t;
    }
    
    @Override
    public void run()
    {
        for(int i=tempo;i>0;i--)
        {
            try {
                System.out.println("Secondi :" +i);
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CountDown.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
