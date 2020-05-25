
package gamethreads;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Luis Eduardo Escobar
 */
public class Field extends JFrame{
    
    JLabel labelRabbit,labelTurtle, labelField;
    JButton startButton, rabbitWin, restart;
     private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
    boolean pressed = false;
    
    
    public Field(){
        super("Race rabbit and turtle");
        
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
                             
        getContentPane().setLayout(null);
        
        labelField = new JLabel();
        getContentPane().add(labelField);
        labelField.setIcon(new ImageIcon(getClass().getResource("grass.png")));
        labelField.setBounds( 100 ,0,450, alto-(alto /8) );
        
        //rabbit
        labelRabbit = new JLabel();
        labelField.add(labelRabbit);
        labelRabbit.setIcon(new ImageIcon(getClass().getResource("rabbit.gif")));
        labelRabbit.setBounds(50,600,200,200);
        
        //turtle
        labelTurtle = new JLabel();
        labelField.add(labelTurtle);
        labelTurtle.setIcon(new ImageIcon(getClass().getResource("turtle.gif")));
        labelTurtle.setBounds(250,600,200,200);
        
     
        
        //create button to play
        startButton = new JButton("Turtle");
        getContentPane().add(startButton);
        startButton.setBounds(5,10,90,70);
        
        //Activate Button
        startButton.addActionListener(  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //labelTurtle.setBounds(250,600,200,200);
                Rabbit rabbit = new Rabbit ( 600,500, 100, 1000 , labelRabbit);
                Turtle turtle =  new Turtle ( 600, 600, 1000, labelTurtle );
                Thread rabbitThread = new Thread( rabbit );   // (int position,int speed, int rest,int distance, JLabel labelRabbit){
                Thread turtleThread = new Thread( turtle );  
                rabbitThread.start();       
                turtleThread.start();
                rabbit.otherThread(turtleThread);
                turtle.otherThread(rabbitThread);
                
                String winner;
//                boolean f=true;
//                //it checks if any of the threads end,but it has to check it constantly
//                while(f){
//                    //System.out.println("Turtle is alive "+turtleThread.isAlive()+" rabbit "+rabbitThread.isAlive());
//                    //until one of threads end its task, thats how we know what thread ends first
//                    if(rabbitThread.isAlive() && !turtleThread.isAlive()){
//                        rabbitThread.interrupt();
//                        System.out.println("The turtle WON");
//                        winner="TURTLE WON";
//                        labelRabbit = new JLabel(winner);
//                         getContentPane().add(labelRabbit);
//                        labelRabbit.setBounds(5,100,200,200);
//                        
//                        f=false;
//                    }
//                    else if(!rabbitThread.isAlive() && turtleThread.isAlive()) {
//                        turtleThread.interrupt();
//                        System.out.println("The rabbit WON");
//                        winner="RABBIT WON";
//                        labelRabbit = new JLabel(winner);
//                         getContentPane().add(labelRabbit);
//                        labelRabbit.setBounds(5,100,200,200);
//                        f=false;
//                    }
//                    if(!rabbitThread.isAlive() && !turtleThread.isAlive())
//                        f=false;
//                }


                }
            } );           
        
        //rabbit Win
        rabbitWin = new JButton("Rabbit");
        getContentPane().add(rabbitWin);
        rabbitWin.setBounds(5,100,90,70);
        
        //Activate Button
        rabbitWin.addActionListener(  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //labelTurtle.setBounds(250,600,200,200);
                Thread rabbitThread = new Thread( new Rabbit ( 600, 600, 0, 1000 , labelRabbit));   // (int position,int speed, int rest,int distance, JLabel labelRabbit){
                Thread turtleThread = new Thread( new Turtle ( 600, 1, 1000, labelTurtle ));  
                rabbitThread.start();       
                turtleThread.start();
                String winner;
                boolean f=true;
                //it checks if any of the threads end,but it has to check it constantly
                while(f){
                    //System.out.println("Turtle is alive "+turtleThread.isAlive()+" rabbit "+rabbitThread.isAlive());
                    //until one of threads end its task, thats how we know what thread ends first
                    if(rabbitThread.isAlive() && !turtleThread.isAlive()){
                        rabbitThread.interrupt();
                        System.out.println("The turtle WON");
                        winner="TURTLE WON";
                        labelRabbit = new JLabel(winner);
                         getContentPane().add(labelRabbit);
                        labelRabbit.setBounds(5,100,200,200);
                        
                        f=false;
                    }
                    else if(!rabbitThread.isAlive() && turtleThread.isAlive()) {
                        turtleThread.interrupt();
                        System.out.println("The rabbit WON");
                        winner="RABBIT WON";
                        labelRabbit = new JLabel(winner);
                         getContentPane().add(labelRabbit);
                        labelRabbit.setBounds(5,100,200,200);
                        f=false;
                    }
                    if(!rabbitThread.isAlive() && !turtleThread.isAlive())
                        f=false;
                }
                
         
            }
        } );  
        
           //create button to RESTART
        restart = new JButton("RESTART");
        getContentPane().add(restart);
        restart.setBounds(5,400,90,70);
        restart.addActionListener(  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                labelRabbit.setBounds(50,600,200,200);
                labelTurtle.setBounds(250,600,200,200);                
            }
        
        } );  
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(ancho/3, 0 , ancho/3 , alto - (alto / 6) );
        setVisible( true ); 
        setResizable(false);
    }
    private  boolean flagTurtle = false; private  boolean flagRabbit = false;
    
     public synchronized void endOfRace(int finalPosition, String winner){
        if( finalPosition <= 0 && winner.contains("TURTLE")){
            
            //Thread.currentThread().interrupt();           
            System.out.println("The winner is "+winner);
            //Thread.currentThread().interrupt();                 
            labelField = new JLabel(winner);
            getContentPane().add(labelField);
            labelField.setBounds(5,70,90,70);
            flagTurtle = true;
            
            
        }
        else if( finalPosition <= 0 && winner.contains("RABBIT")){
            //Thread.currentThread().interrupt();           
            System.out.println("The winner is "+winner);
            //Thread.currentThread().interrupt();                
            labelField = new JLabel(winner);
            getContentPane().add(labelField);
            labelField.setBounds(5,70,90,70);
           flagRabbit = true;
        }
         if(flagRabbit ==true && flagTurtle == true ){
            System.out.println("Both WIIIN!!!");
        }
        
    

    }
 
}
    
