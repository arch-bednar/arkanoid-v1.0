package arkanoid;

import java.awt.geom.Rectangle2D;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Board extends Rectangle2D.Double{
    public Board(int width, int height){
        super(200, 250, width, height);
    }

    void setX(double x){
        this.x = x;
    }
}
