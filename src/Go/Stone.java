package Go;

import Go.State;
import java.awt.Point;
import java.io.Serializable;
import java.lang.Double;
/**
 * The piece that is placed by a player each move.
 *
 */
public class Stone {

    public State state;
    public Point point;
    public int turnNumberPlaced;

    public Stone(Point point, State state, int number) {
	this.state = state;
	this.point = point.getLocation();
    this.turnNumberPlaced = number;
    }
    
    public State getState() {
    return this.state;
    }

    public Point getLocation(){
        return this.point;
    }

    public int getX(){
        int x = (int) point.getX();
        return x;
    }

    public int getY(){
        int y = (int) point.getY();
        return y;
    }
}
