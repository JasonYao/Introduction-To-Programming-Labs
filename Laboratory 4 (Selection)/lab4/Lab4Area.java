/*
 * Lab4Area.java - draws a robot whose appearance is customized based
 * on which boxes are checked.
 */

 // import the relevant packages from the Java library
 import java.awt.*;

/*
 * class Lab4Area - defines a 'paint' method that draws a robot
 *
 */
public class Lab4Area extends Lab4BaseArea {
    ////////////////////////////////////////////////////////////
    // paint - draws the frame's "art" on the screen
    //
    // calling sequence:
    //   paint(g); // called automatically when needed
    //
    // parameters:
    //   g - the graphics object on which to draw
    //
    // side-effects:
    //   causes the visible screen to be modified
    //
    // bugs/anomalies:
    //   (none known)
    //
    ////////////////////////////////////////////////////////////
    public void paint(Graphics g) {
        // Over rides the left side of the robot
        if (!isChecked("left normal"))
        {
            g.setColor(Color.black);
            g.fillPolygon(leftArm);
            g.fillPolygon(rightArm);
            g.fillPolygon(leftLeg);
            g.fillPolygon(rightLeg);
            
            g.setColor(Color.blue);
            g.fillPolygon(leftEye);
            g.fillPolygon(rightEye);
            
            g.setColor(Color.pink);
            g.fillPolygon(leftEar);
            g.fillPolygon(rightEar);
        
        
        //Custom Colour
        Color silver = new Color(192,192,192);
        g.setColor(silver);
        g.fillPolygon(body);
        // Checks the body colour, and sets
        if (isChecked("silver body"))
        {
            g.setColor(silver);
        }
        else if (isChecked("green body"))
        {
            g.setColor(Color.green);
        }
        else if (isChecked("pink body"))
        {
            g.setColor(Color.pink);
        }
        else if (isChecked("sky blue body"))
        {
            g.setColor(Color.cyan);
        }
        // Draw the main body
        g.fillPolygon(body);
        
        // Checks the robot's legs
        g.setColor(Color.green);
        Polygon myLeftLeg = leftLeg;
        Polygon myRightLeg = rightLeg;
        if ((!isChecked("bent legs")) && (!isChecked("left normal")))
        {
            g.fillPolygon(myLeftLeg);
            g.fillPolygon(myRightLeg);
        }
        if (((isChecked("bent legs")) && (isChecked("big feet"))) && (!isChecked("left normal")))
        {
            // Sets the legs to big feet and bent
            myLeftLeg = leftLegBentBigFeet;
            myRightLeg = rightLegBentBigFeet;
            g.fillPolygon(myLeftLeg);
            g.fillPolygon(myRightLeg);
        }
        else if ((isChecked("bent legs")) && (!isChecked("left normal")))
        {
            // Sets feet to bent
            myLeftLeg = leftLegBent;
            myRightLeg = rightLegBent;
            g.fillPolygon(myLeftLeg);
            g.fillPolygon(myRightLeg);
        }
        else if ((isChecked("big feet")) && (!isChecked("left normal")))
        {
            // Sets feet to big feet
            myLeftLeg = leftLegBigFeet;
            myRightLeg = rightLegBigFeet;
            g.fillPolygon(myLeftLeg);
            g.fillPolygon(myRightLeg);
        }

        // Customizes the Robot's ears colour
        Polygon myLeftEar = leftEar;
        Polygon myRightEar = rightEar;
        if (((isChecked("red ears")) && (isChecked("blue ears"))) && (!isChecked("left normal")))
        {
            Color purple = new Color(255, 0, 255);
            g.setColor(purple);
            g.fillPolygon(myLeftEar);
            g.fillPolygon(myRightEar);
        }
        else if ((isChecked("red ears")) && (!isChecked("left normal")))
        {
            g.setColor(Color.red);
            g.fillPolygon(myLeftEar);
            g.fillPolygon(myRightEar);
        }
        else if ((isChecked("blue ears")) && (!isChecked("left normal")))
        {
            g.setColor(Color.blue);
            g.fillPolygon(myLeftEar);
            g.fillPolygon(myRightEar);
        }

        // Customize's the robot's mouth
        Polygon myMouth = smileMouth;
        g.setColor(Color.red);
        if (!(isChecked("frown")) && !(isChecked("whistle")))
        {
            g.fillPolygon(myMouth);
        }
        else if ((isChecked("frown")) && (isChecked("whistle")))
        {
            if (whistleMoreRecent())
            {
                g.fillPolygon(whistleMouth);
            }
            else
            {
                g.fillPolygon(frownMouth);
            }
        }
        else if (isChecked("frown"))
        {
            g.fillPolygon(frownMouth);
        }
        else if (isChecked("whistle"))
        {
            g.fillPolygon(whistleMouth);  
        }
        
        // Customize the robot's eyes
        Polygon myLeftEye = leftEye;
        Polygon myRightEye = rightEye;
        g.setColor(Color.blue);
        if ((isChecked("cross-eyed")) && (!isChecked("left normal")))
        {
            g.fillPolygon(leftEyeIn);
            g.fillPolygon(rightEyeIn);
        }
        else if (((isChecked("look left")) && (isChecked("look right"))) && (!isChecked("left normal")))
        {
            g.fillPolygon(myLeftEye);
            g.fillPolygon(myRightEye);
        }
        else if ((isChecked("look left")) && (!isChecked("left normal")))
        {
            g.fillPolygon(leftEyeOut);
            g.fillPolygon(rightEyeIn);
        }
        else if ((isChecked("look right")) && (!isChecked("left normal")))
        {
            g.fillPolygon(leftEyeIn);
            g.fillPolygon(rightEyeOut);
        }
        else
        {
            g.fillPolygon(myLeftEye);
            g.fillPolygon(myRightEye);
        }
        
        // Sets colour of the eyes to green if checked
        g.setColor(Color.GREEN);
        if ((isChecked("green eyes")) && (!isChecked("left normal")))
        {
            g.fillPolygon(myLeftEye);
            g.fillPolygon(myRightEye);
        }
        if (((isChecked("green eyes")) && (isChecked("green body"))) && (!isChecked("left normal")))
        {
            Color lightgreen = new Color(32, 178, 170);
            g.setColor(lightgreen);
            g.fillPolygon(body);
            g.setColor(Color.GREEN);
            g.fillPolygon(myLeftEye);
            g.fillPolygon(myRightEye);
        }
        
        // Customizes options based upon number of options checked
        int numberChecked = totalNumChecked();
        if (numberChecked > 10)
        {
            g.setColor(Color.black);
            g.fillPolygon(myMouth);
        }
        else if (numberChecked%2 == 0)
        {
            g.setColor(Color.white);
            g.fillPolygon(myMouth);
        }
        else if ((numberChecked == 2) || (numberChecked ==3) || (numberChecked ==5) || (numberChecked ==7))
        {
            g.setColor(Color.orange);
            g.fillPolygon(myMouth);
        }
        else
        {
            g.setColor(Color.red);
            g.fillPolygon(myMouth);
        }
        
        // Customizes the robot's arms
        if ((isChecked("short arms")) && (!isChecked("left normal")))
        {
            g.fillPolygon(shortLeftArm);
            g.fillPolygon(shortRightArm);
        }
        else if (((isChecked("arms bent up")) && (isChecked("arms bent down")) && (isChecked("long arms"))) && (!isChecked("left normal")))
        {
            g.fillPolygon(longLeftArmBentDown);
            g.fillPolygon(longRightArmBentDown);
        }
        else if (((isChecked("short arms")) && (isChecked("long arms"))) && (!isChecked("left normal")))
        {
            g.fillPolygon(shortLeftArm);
            g.fillPolygon(shortRightArm);
        }
        else if(((isChecked("arms bent up")) && (isChecked("arms bent down"))) && (!isChecked("left normal")))
        {
            g.fillPolygon(leftArmBentDown);
            g.fillPolygon(rightArmBentDown);
        }
        else if (((isChecked("long arms")) && (isChecked("arms bent up"))) && (!isChecked("left normal")))
        {
            g.fillPolygon(longLeftArmBentUp);
            g.fillPolygon(longRightArmBentUp);
        }
        else if (((isChecked("long arms")) && (isChecked("arms bent down"))) && (!isChecked("left normal")))
        {
            g.fillPolygon(longLeftArmBentDown);
            g.fillPolygon(longRightArmBentDown);
        }
        else if ((isChecked("long arms")) && (!isChecked("left normal")))
        {
            g.fillPolygon(longLeftArm);
            g.fillPolygon(longRightArm);
        }
        else if ((isChecked("arms bent down")) && (!isChecked("left normal")))
        {
            g.fillPolygon(leftArmBentDown);
            g.fillPolygon(rightArmBentDown);
        }
        else if ((isChecked("arms bent up")) && (!isChecked("left normal")))
        {
            g.fillPolygon(leftArmBentUp);
            g.fillPolygon(rightArmBentUp);
        }
        else
        {
            g.fillPolygon(leftArm);
            g.fillPolygon(rightArm);
        }
    }
    else //Basically the copy
    {
        //Custom Colour
        Color silver = new Color(192,192,192);
        g.setColor(silver);
        g.fillPolygon(body);
        // Checks the body colour, and sets
        if (isChecked("silver body"))
        {
            g.setColor(silver);
        }
        else if (isChecked("green body"))
        {
            g.setColor(Color.green);
        }
        else if (isChecked("pink body"))
        {
            g.setColor(Color.pink);
        }
        else if (isChecked("sky blue body"))
        {
            g.setColor(Color.cyan);
        }
        // Draw the main body
        g.fillPolygon(body);
        
        // Checks the robot's legs
        g.setColor(Color.green);
        Polygon myRightLeg = rightLeg;
        if ((!isChecked("bent legs")))
        {
            g.fillPolygon(myRightLeg);
        }
        if (((isChecked("bent legs")) && (isChecked("big feet"))))
        {
            // Sets the legs to big feet and bent
            myRightLeg = rightLegBentBigFeet;
            g.fillPolygon(myRightLeg);
        }
        else if ((isChecked("bent legs")))
        {
            // Sets feet to bent
            myRightLeg = rightLegBent;
            g.fillPolygon(myRightLeg);
        }
        else if ((isChecked("big feet")))
        {
            // Sets feet to big feet
            myRightLeg = rightLegBigFeet;
            g.fillPolygon(myRightLeg);
        }

        // Customizes the Robot's ears colour
        Polygon myRightEar = rightEar;
        if (((isChecked("red ears")) && (isChecked("blue ears"))))
        {
            Color purple = new Color(255, 0, 255);
            g.setColor(purple);
            g.fillPolygon(myRightEar);
        }
        else if ((isChecked("red ears")))
        {
            g.setColor(Color.red);
            g.fillPolygon(myRightEar);
        }
        else if ((isChecked("blue ears")))
        {
            g.setColor(Color.blue);
            g.fillPolygon(myRightEar);
        }

        // Customize's the robot's mouth
        Polygon myMouth = smileMouth;
        g.setColor(Color.red);
        if (!(isChecked("frown")) && !(isChecked("whistle")))
        {
            g.fillPolygon(myMouth);
        }
        else if ((isChecked("frown")) && (isChecked("whistle")))
        {
            if (whistleMoreRecent())
            {
                g.fillPolygon(whistleMouth);
            }
            else
            {
                g.fillPolygon(frownMouth);
            }
        }
        else if (isChecked("frown"))
        {
            g.fillPolygon(frownMouth);
        }
        else if (isChecked("whistle"))
        {
            g.fillPolygon(whistleMouth);  
        }
        
        // Customize the robot's eyes
        Polygon myRightEye = rightEye;
        g.setColor(Color.blue);
        if ((isChecked("cross-eyed")))
        {
            g.fillPolygon(rightEyeIn);
        }
        else if (((isChecked("look left")) && (isChecked("look right"))))
        {
            g.fillPolygon(myRightEye);
        }
        else if ((isChecked("look left")))
        {
            g.fillPolygon(rightEyeIn);
        }
        else if ((isChecked("look right")))
        {
            g.fillPolygon(rightEyeOut);
        }
        else
        {
            g.fillPolygon(myRightEye);
        }
        
        // Sets colour of the eyes to green if checked
        g.setColor(Color.GREEN);
        if ((isChecked("green eyes")))
        {
            g.fillPolygon(myRightEye);
        }
        if (((isChecked("green eyes")) && (isChecked("green body"))))
        {
            Color lightgreen = new Color(32, 178, 170);
            g.setColor(lightgreen);
            g.fillPolygon(body);
            g.setColor(Color.GREEN);
            g.fillPolygon(myRightEye);
        }
        
        // Customizes options based upon number of options checked
        int numberChecked = totalNumChecked();
        if (numberChecked > 10)
        {
            g.setColor(Color.black);
            g.fillPolygon(myMouth);
        }
        else if (numberChecked%2 == 0)
        {
            g.setColor(Color.white);
            g.fillPolygon(myMouth);
        }
        else if ((numberChecked == 2) || (numberChecked ==3) || (numberChecked ==5) || (numberChecked ==7))
        {
            g.setColor(Color.orange);
            g.fillPolygon(myMouth);
        }
        else
        {
            g.setColor(Color.red);
            g.fillPolygon(myMouth);
        }
        
        // Customizes the robot's arms
        if ((isChecked("short arms")))
        {
            g.fillPolygon(shortRightArm);
        }
        else if (((isChecked("arms bent up")) && (isChecked("arms bent down")) && (isChecked("long arms"))))
        {
            g.fillPolygon(longRightArmBentDown);
        }
        else if (((isChecked("short arms")) && (isChecked("long arms"))))
        {
            g.fillPolygon(shortRightArm);
        }
        else if(((isChecked("arms bent up")) && (isChecked("arms bent down"))))
        {
            g.fillPolygon(rightArmBentDown);
        }
        else if (((isChecked("long arms")) && (isChecked("arms bent up"))))
        {
            g.fillPolygon(longRightArmBentUp);
        }
        else if (((isChecked("long arms")) && (isChecked("arms bent down"))))
        {
            g.fillPolygon(longRightArmBentDown);
        }
        else if ((isChecked("long arms")))
        {
            g.fillPolygon(longRightArm);
        }
        else if ((isChecked("arms bent down")) )
        {
            g.fillPolygon(rightArmBentDown);
        }
        else if ((isChecked("arms bent up")))
        {
            g.fillPolygon(rightArmBentUp);
        }
        else
        {
            g.fillPolygon(rightArm);
        }
        g.setColor(Color.black);
        g.fillPolygon(leftArm);
        g.fillPolygon(leftLeg);
            
        g.setColor(Color.blue);
        g.fillPolygon(leftEye);

        g.setColor(Color.pink);
        g.fillPolygon(leftEar);

    }
    
    }
}
