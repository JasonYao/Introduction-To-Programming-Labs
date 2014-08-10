////////////////////////////////////////////////////////
// FaceFrame.java - draws faces
//
////////////////////////////////////////////////////////

// imports
import javax.swing.*;
import java.awt.*;

////////////////////////////////////////////////////////
// class FaceFrame - draws some faces on the screen
//
// This frame creates a dozen faces of various kinds,
// and displays them on the screen
//
////////////////////////////////////////////////////////
public class FaceFrame extends JFrame {

    ////////////////////////////////////////////////////////
    // main - creates and displays the frame
    ////////////////////////////////////////////////////////
    public static void main(String[] args) {
        FaceFrame f = new FaceFrame();
        f.setVisible(true);
    }
    
    /////////////////////////
    // INSTANCE VARIABLES
    /////////////////////////

    // The twelve faces
    private Face[] faces;
    
    // The labels for the faces
    private FaceLabel[] labels;

    ////////////////////////////////////////////////////////
    // constructor
    ////////////////////////////////////////////////////////
    public FaceFrame() {
        setSize(700,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
    }

    ////////////////////////////////////////////////////////
    // init - initializes the display
    //
    // side-effects:
    //   creates the faces to be displayed; sets the background color
    //
    // bugs/anomalies:
    //   none known.
    //
    ////////////////////////////////////////////////////////
    public void init() {
        
        int deltaY = 10;

        // set the background color
        setBackground(Color.orange);
        
        // create the face-array
        faces = new Face[12];
        
        // create the label-array
        labels = new FaceLabel[12];

        // create first row: normal, happy, embarrased, normal
        faces[0] = new Face(100, 150);
        faces[0].setLocation(20,30+deltaY);
        labels[0] = new FaceLabel("face", 55, 195+deltaY);
        faces[1] = new HappyFace(100,100);
        faces[1].setLocation(320, 30+deltaY);
        labels[1] = new FaceLabel("happy", 350, 145+deltaY);
        faces[2] = new EmbarassedFace(80,105+deltaY);
        faces[2].setLocation(170, 30+deltaY);
        labels[2] = new FaceLabel("embarassed", 170, 155+deltaY);
        faces[3] = new Face(130, 70);
        faces[3].setLocation(500,30+deltaY);
        labels[3] = new FaceLabel("face", 550, 115+deltaY);

        // create second row: sad, jealous, groucho, sad
        faces[4] = new SadFace(120,90);
        faces[4].setLocation(20, 235+deltaY);
        labels[4] = new FaceLabel("sad", 70, 340+deltaY);
        faces[5] = new JealousFace(115, 140);
        faces[5].setLocation(170, 180+deltaY);
        labels[5] = new FaceLabel("jealous", 205, 335+deltaY);
        faces[6] = new GrouchoFace(120, 100);
        faces[6].setLocation(330, 200+deltaY);
        labels[6] = new FaceLabel("groucho", 365, 315+deltaY);
        faces[7] = new SadFace(80,120);
        faces[7].setLocation(500, 155+deltaY);
        labels[7] = new FaceLabel("sad", 530, 290+deltaY);

        // create third row: happy, embarassed, jealous, groucho
        faces[8] = new HappyFace(140,250);
        faces[8].setLocation(30, 390+deltaY);
        labels[8] = new FaceLabel("happy", 80, 655+deltaY);
        faces[9] = new EmbarassedFace(55,150);
        faces[9].setLocation(250, 380+deltaY);
        labels[9] = new FaceLabel("embarassed", 240, 545+deltaY);
        faces[10] = new JealousFace(130,65);
        faces[10].setLocation(225, 580+deltaY);
        labels[10] = new FaceLabel("jealous", 265, 665+deltaY);
        faces[11] = new GrouchoFace(210, 320);
        faces[11].setLocation(410, 345+deltaY);
        labels[11] = new FaceLabel("groucho", 490, 680+deltaY);

    }

////////////////////////////////////////////////////////
// paint - paints the window
//
// parameters:
//   g - the Graphics object
//
// side-effects:
//   draws faces on the graphics object.  This method
//   leaves the graphics object's color unchanged.
//
// bugs/anomalies:
//   none known.
//
////////////////////////////////////////////////////////
    public void paint(Graphics g) {

        // draw the faces
        for (int i = 0; i < faces.length; i++) {
            faces[i].drawOn(g);
            if (labels[i] != null) {
                labels[i].drawOn(g);
            }
        }
    }
}

