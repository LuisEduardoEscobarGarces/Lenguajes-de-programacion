
package gamethreads;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;


/**
 *
 * @author Luis Eduardo Escobar
 */
public class Field extends JFrame  {

    JLabel labelRabbit,labelTurtle, labelField, labelWinner;
    JButton startButton, turtleButton, rabbitButton, tieButton, stopButton;
    private static final long serialVersionUID = 1L;
    private JPanel panel; 
    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
     
    boolean pressed = false;
    private  int arrowLeft , arrowRight, arrowUp , arrowDown;
    Character rabbitP ;
    Character turtleP ;
    
    public Field(){
        super("Race rabbit and turtle");
        //kPressed();
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
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
        startButton = new JButton("START");
        getContentPane().add(startButton);
        startButton.setBounds(5,10,90,70);
        
        //Activate Button
        startButton.addActionListener((ActionEvent ae) -> {
            Character rabbitP = new Character ( "Rabbit",600, 20, 200 , labelRabbit, "");
            Character turtleP = new Character ( "Turtle",600, 10, 50 , labelTurtle, "");
            Thread rabbitThread = new Thread( rabbitP );
            Thread turtleThread = new Thread( turtleP );
            rabbitThread.start();
            turtleThread.start();
            rabbitP.setCharacterThread(turtleThread);
            turtleP.setCharacterThread(rabbitThread);

        });          
        
        //create button to play
        turtleButton = new JButton("Turtle");
        getContentPane().add(turtleButton);
        turtleButton.setBounds(5,100,90,70);
        
        //Activate Button
        turtleButton.addActionListener((ActionEvent ae) -> {
            Character rabbitP = new Character ( "Rabbit",600, 50, 200 , labelRabbit, "");
            Character turtleP = new Character ( "Turtle",600, 10, 10 , labelTurtle, "");
            Thread rabbitThread = new Thread( rabbitP );
            Thread turtleThread = new Thread( turtleP );
            rabbitThread.start();
            turtleThread.start();
            rabbitP.setCharacterThread(turtleThread);
            turtleP.setCharacterThread(rabbitThread);
        }); 
        
          //create button to play
        rabbitButton = new JButton("Rabbit");
        getContentPane().add(rabbitButton);
        rabbitButton.setBounds(5,200,90,70);
        
        //Activate Button
        rabbitButton.addActionListener((ActionEvent ae) -> {
            Character rabbitP = new Character ( "Rabbit",600, 90, 300 , labelRabbit, "");
            Character turtleP = new Character ( "Turtle",600, 10, 20 , labelTurtle, "");
            Thread rabbitThread = new Thread( rabbitP );
            Thread turtleThread = new Thread( turtleP );
            rabbitThread.start();
            turtleThread.start();
            rabbitP.setCharacterThread(turtleThread);
            turtleP.setCharacterThread(rabbitThread);
        }); 
        
        
        
        //create button to play
        tieButton = new JButton("TIE");
        getContentPane().add(tieButton);
        tieButton.setBounds(5,300,90,70);
        
        //Activate Button
        tieButton.addActionListener((ActionEvent ae) -> {
            String winCondition = "tie";
            Character rabbitP = new Character ( "Rabbit",600, 50, 300 , labelRabbit, winCondition);
            Character turtleP = new Character ( "Turtle",600, 50, 300 , labelTurtle, winCondition);
            Thread rabbitThread = new Thread( rabbitP );
            Thread turtleThread = new Thread( turtleP );
            rabbitThread.start();
            turtleThread.start();
            rabbitP.setCharacterThread(turtleThread);
            turtleP.setCharacterThread(rabbitThread);
        }); 
        
        
        setVisible( true ); 
        setResizable(false);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(ancho/3, 0 , ancho/3 , alto - (alto / 6) );
       
     
    }    

   

 
}
    
