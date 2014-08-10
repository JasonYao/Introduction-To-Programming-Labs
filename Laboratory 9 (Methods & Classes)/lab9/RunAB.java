import java.awt.*;

// class RunAB is a tester-applet for the Die classs
public class RunAB extends RunAbstract {
    protected Die myDie;

    public static void main(String[] args) {
        new RunAB().setVisible(true);
    }
    
    public RunAB() {
        super();
    }
    
    // displays things on the canvas
    public void display(Graphics g) {
        super.display(g);
        myDie.paint(g); // paint the first die
    }
    
    // process button-press
    protected void processRollButton() {
        super.processRollButton();
        myDie.roll(canvas.getGraphics()); // reroll first die
    }
    
    
    // method that adds the dice
    protected void addDice() {
        super.addDice();
        
        // create the die at 50,100
        myDie = new Die(50, 100);
    }
}
