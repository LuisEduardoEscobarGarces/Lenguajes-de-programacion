/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamethreads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Luis Eduardo Escobar
 */
public class Turtle implements Runnable{

    private int speed;
    private int distance;
    private int position;
    Field field;
    Races races;
    JLabel labelTurtle;
    public Turtle(int position,int speed, int distance, JLabel labelTurtle){
        this.clq = new ConcurrentLinkedQueue<Integer>();
        this.position = position;
        this.speed = speed;
        this.distance = distance;
        this.labelTurtle = labelTurtle;
    }
    public void move(){
        position = position - speed;
    }
    
    ConcurrentLinkedQueue<Integer> clq; 
    @Override
    public void run() {
        while( position >= 0 ){
            move();
            String winner="TURTLE";
            if(position < 0 ){
               //priorityBlockingQueue.add(winner);
                //races.numRaces(priorityBlockingQueue ); 
                //clq = new ConcurrentLinkedQueue<>();
                //clq.add(2);
                //System.out.println(clq.peek());
//                races = new Races();
//                try {
//                    races.numRaces(clq);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Turtle.class.getName()).log(Level.SEVERE, null, ex);
//                }
                //field = new Field();
                //field.endOfRace(position, winner);
               //Thread.currentThread().interrupt();
               labelTurtle.setBounds(250,position,200,200);
            }
            
        }
    }
    
}
