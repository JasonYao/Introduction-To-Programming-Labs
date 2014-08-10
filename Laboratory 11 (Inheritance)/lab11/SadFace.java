import java.awt.*;

public class SadFace extends HappyFace {
    public SadFace(int w, int h) {
        super(w, h);
    }

    protected Polygon2 createMouth()
    {
        Polygon2 frown = super.createMouth();
        frown = frown.rotateBy(180);
        return frown;
    }

    protected void drawMouth(Graphics g)
    {
        g.setColor(Color.BLACK);
        createMouth();
        g.fillPolygon(createMouth());
    }

    protected void drawNose(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillOval(pixelX(45), pixelY(55), 10, 10);
    }

}
