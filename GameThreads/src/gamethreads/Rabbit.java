/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamethreads;

import java.awt.event.KeyEvent;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

/**
 *
 * @author Luis Eduardo Escobar
 */
public class Rabbit implements Runnable{
    private int speed;
    private int rest;
    private int distance;
    private int position;
    Rabbit rabbit;
    Races races;
    Field field;
    JLabel labelRabbit;
 
    
    public Rabbit(int position,int speed, int rest,int distance, JLabel labelRabbit){
        this.position = position;
        this.speed = speed;
        this.rest = rest;
        this.distance = distance; 
        this.labelRabbit = labelRabbit;
        
    }
    public void move(){
        position = position - speed;
    }
 
    ConcurrentLinkedQueue<Integer> clq ; 
    @Override
    public void run() {
        try{
            
            while( position >= 0 ){
                move();
                String winner="RABBIT";
                //System.out.println("pos"+position);
                if(position < 0 ){

                    //clq = new ConcurrentLinkedQueue<>();   
                    //clq.add(1);
                    //races = new Races();
                    //races.numRaces(clq);
                    
                    labelRabbit.setBounds(50,position,200,200);
                    Thread.sleep(rest);
                    //field = new Field();
                    //field.endOfRace(position, winner);
                    
                }
                
                
            }
        } 
        catch(InterruptedException e){
        
        }
        
    }
    
}
