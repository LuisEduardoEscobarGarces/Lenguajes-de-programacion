/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamethreads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author Luis Eduardo Escobar
 */
public class Races {
    
    private static ConcurrentLinkedQueue<Integer> clq2 ; 
    Rabbit rabbit;
    Turtle turtle;
    private static boolean flag=false;
    public synchronized void  numRaces( ConcurrentLinkedQueue<Integer> clq) throws InterruptedException{
        clq2 = new ConcurrentLinkedQueue<>();
        clq2.add( clq.peek() );
        
        if( clq2.size() == 1 ){
            if(flag == false){
                //clq2.remove();
                flag = true;
            }
            
            flag = true;
            if( clq2.peek() == 2 && flag == true ){
                System.out.println("Wins TURTLE");
                System.out.println("Loses RABBIT");
                flag = true;
                clq2.remove();
            }
            else if( clq2.peek() == 2 && flag == false ){
                System.out.println("Wins RABBIT");
                flag = true;
                clq2.remove();
                
            }
            
        }
   
    
    }
    
    public synchronized void food(int random, ConcurrentLinkedQueue<Integer> clq ){
        if( random == 2 ){
            
        }
        
    }
}
