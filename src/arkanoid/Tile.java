package arkanoid;

import java.awt.geom.Rectangle2D;

public class Tile extends Rectangle2D.Double{

    private boolean alive = true;
    public double leftEdge, rightEdge, upperEdge, lowerEdge;

    public Tile(double x, double y, double width, double height){
        super(x, y, width, height);

        leftEdge = x;
        rightEdge = x + width;
        upperEdge = y;
        lowerEdge = y + height;
    }

    public void setStatus(){
        this.alive = false;
        x = -60;
        y = -60;
    }

    public boolean getStatus(){
        return this.alive;
    }

    public void isHited(Ball ball){
        if(ball.intersects(this)){
            if(ball.y == lowerEdge -1){
                System.out.println("dol kafelki");
                ball.setDestinationY();
            }else if(ball.y == upperEdge){
                System.out.println("gora kafelki");
                ball.setDestinationY();
            }else if(ball.x + ball.getRadius() * 2 == leftEdge + 1){
                System.out.println("lewa strona kafelki");
                ball.setDestinationX();
            }else if(ball.x == rightEdge - 1){
                System.out.println("prawa strona kafelki");
                ball.setDestinationX();
            }
            this.setStatus();
        }
    }

}
