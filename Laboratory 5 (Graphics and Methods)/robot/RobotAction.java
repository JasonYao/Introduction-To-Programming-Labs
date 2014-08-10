
public class RobotAction
{
    public void runRobot(Robot robbie) throws RobotException {
        ///// *** your robot-moving code should start here ***
        // Moves forwards, then stops

        //Part 7
        while (!robbie.isFrontBlocked())
        {
                robbie.turnRight();
                
                if (!robbie.isFrontBlocked())
                {
                    robbie.forward();
                    if (robbie.isFrontBlocked())
                    {
                        robbie.turnRight();
                        robbie.forward();
                        robbie.turnLeft();
                        if (!robbie.isFrontBlocked())
                        {
                            robbie.forward();
                        }
                    }
                }
            }
            
            
            
          int = 0;
          
        } 
            
            
            
            
            
            
            
            
            
            
            
        }

        //Part 7
        //while ()
        //{

        //}

        //        while (!robbie.isFrontBlocked())
        //    {
        //    if (!robbie.isFrontBlocked())
        //    {
        //        robbie.forward();
        //        ++count;
        //    }
        //}

        // Turns robot around
        //robbie.turnLeft();
        //robbie.turnLeft();

        // Moves forwards, then stops
        //while (!robbie.isFrontBlocked())
        //{
        //    if (!robbie.isFrontBlocked())
        //   {
        //      robbie.forward();
        // }
        //}

        ///// *** your robot-moving code should end here ***
