package gamethreads;


import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Luis Eduardo Escobar
 */
public class Character extends JFrame implements Runnable {
    private int position;
    private int speed;
    private int rest;
    private String winCondition;
    private String nameCharacter;
   

    JLabel labelCharacter, labelWinner;
    Thread characterThread;
    JPanel panel;

    public Character(){
       
       
    }
    public Character(String nameCharacter,int position, int speed, int rest, JLabel labelCharacter, String winCondition){
        this.nameCharacter = nameCharacter;
        this.position = position;
        this.speed = speed;
        this.rest = rest;
        this.labelCharacter = labelCharacter;  
        this.winCondition = winCondition;    
    } 
    
    public void setCharacterThread(Thread characterThread){
        this.characterThread = characterThread;
    }    
    
    public void setPosition(int position){
        this.position = position;
    }
    public int getPosition(){
        return position;
    }


    @Override
    public void run() {
        try{                    
            while(characterThread.isAlive()  ){

                while( getPosition() > 0 ){ 
                    if( nameCharacter.matches("Turtle")){
                        java.util.Random random = new java.util.Random();
                        int tmp = random.nextInt(5) + 1;

                        if( winCondition.matches("tie") ){ 
                            setPosition(position-(speed-2));
                            Thread.sleep(rest); 
                        }
                        else if( winCondition.matches("") ){
                            if( tmp != 1){
                                setPosition(position-(speed-2));
                            }
                            else{
                                System.out.println("Oh "+nameCharacter+" you will go back 10 steps!");
                                setPosition(position+(10));
                            }   
                            Thread.sleep(rest); 
                        } 
                        labelCharacter.setBounds(250,position,200,200);                         
                    }
                    else if(nameCharacter.matches("Rabbit")){
                        java.util.Random random = new java.util.Random();
                        int tmp = random.nextInt(5) + 1;
                        if( winCondition.matches("tie") ){
                            setPosition(position-(speed-2));
                            Thread.sleep(rest); 
                        }
                        else if( winCondition.matches("")){
                            setPosition(position-(speed-2));
                            if(tmp == 1 ){
                                System.out.println("Oh "+nameCharacter+" you will rest more time!");
                                Thread.sleep(200);
                            }else{
                                Thread.sleep(rest); 
                            }
                        }
                        labelCharacter.setBounds(50,position,200,200);                      
                    }    
                    if(getPosition() <= 0 ){
                        System.out.println( "WINS "+ nameCharacter);                        
                        characterThread.interrupt();       
                        JOptionPane.showMessageDialog(null, "WINS!! "+nameCharacter, "RABBIT VS TURTLE: " , JOptionPane.INFORMATION_MESSAGE);
                    }                   
                }
            }            
        }
        catch(InterruptedException e){              
            System.out.println("LOSES "+nameCharacter);                
        }
    }

 
}
