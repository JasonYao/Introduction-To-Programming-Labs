import java.awt.*;

public class GrouchoFace extends HappyFace {
    public GrouchoFace(int x, int y) { super(x,y); }
    
    protected Color hairColor(){return Color.BLACK;};
    
    protected void drawEyeCenters(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillPolygon(createGlasses());
        g.fillPolygon(createGlasses2());
        
        g.setColor(this.eyeColor());
        super.drawEyeWhites(g);
        super.drawEyeCenters(g);
        
    }
    
    protected void drawNose(Graphics g)
    {
        super.drawNose(g);
        g.setColor(Color.BLACK);
        g.fillRect(pixelX(30), pixelY(68), distX(40), distY(5));
        
        Color Brown = new Color(139,119,101);
        g.setColor(Brown);
        g.fillPolygon(createCigar());
        
        g.setColor(Color.BLACK);
        //g.drawPolygon(createGlasses());
        //g.drawPolygon(createGlasses2());
    }
    
    protected Polygon2 createMouth()
    {
        Polygon2 tiltSmile = super.createMouth();
        tiltSmile = tiltSmile.rotateBy(15);
        return tiltSmile;
    }
    
    protected void drawEars(Graphics g)
    {
        g.drawLine(pixelX(80), pixelY(37), pixelX(100), pixelY(20));
        g.drawLine(pixelX(18), pixelY(37), pixelX(0), pixelY(20));
        super.drawEars(g);
    }
    
    protected Polygon2 createCigar()
    {
        Polygon2 cigar = new Polygon2(100);
        cigar = cigar.fitIn(pixelX(60), pixelY(80), distX(50), distY(13));
        cigar = cigar.rotateBy(48);
        return cigar;
    }
    
    protected Polygon2 createGlasses()
    {
        Polygon2 glasses1 = new Polygon2(100);
        glasses1 = glasses1.fitIn(pixelX(15), pixelY(37), distX(20), distY(15));
        return glasses1;
    }
    
    protected Polygon2 createGlasses2()
    {
        Polygon2 glasses2 = new Polygon2(100);
        glasses2 = glasses2.fitIn(pixelX(68), pixelY(37), distX(20), distY(15));
        return glasses2;
    }
    

}
