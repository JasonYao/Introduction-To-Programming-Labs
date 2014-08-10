import java.awt.*;

public class EmbarassedFace extends SadFace {
    public EmbarassedFace(int x, int y) { super(x,y); }
    
    protected Color headColor(){return Color.RED;};
    
    protected Color mouthColor(){return Color.pink;};
    
    protected void drawEyeWhites(Graphics g) {
		// draw the white portion of the eyes.  The right eye should start
        // 18% in from the left portion of the head and 38% of the way down
        // from the top of the head.  The height and width respectively be
        // 11% of those of the head.  The left eye should be similarly placed,
        // but on the other side.	
        g.setColor(Color.white);
        g.fillOval(pixelX(14), pixelY(30), distX(33), distY(33));
        g.fillOval(pixelX(60), pixelY(30), distX(33), distY(33));
    }

}
