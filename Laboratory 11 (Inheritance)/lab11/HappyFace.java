import java.awt.*;
public class HappyFace extends Face
{
    public HappyFace(int w, int h)
    {
        super(w, h);
    }
    
    protected Polygon2 createMouth()
    {
        Polygon2 smile = new Polygon2(30);
        smile = smile.fitIn(pixelX(20), pixelY(70), distX(60), distY(20));
        return smile;
    }
    
    protected void drawMouth(Graphics g)
    {
        g.setColor(this.mouthColor());
        createMouth();
        g.fillPolygon(createMouth());
    }
}
