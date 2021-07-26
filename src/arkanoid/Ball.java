package arkanoid;

import java.awt.geom.Ellipse2D;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

public class Ball extends Ellipse2D.Double{

    private double dx, dy, r, d;
    private Window window;

    public Ball(Window window, double d){
        super(300, 200, d, d);
        this.dx=-1;
        this.dy=1;
        this.r = d/2;
        this.d=d;
        this.window=window;
    }

    public void nextStep(){
        this.x+=dx;
        this.y+=dy;
        //System.out.println(window.board.y - window.board.height + " " + y);

        if(getMinX()<0 || getMaxX()>window.getWidth()) dx=-dx;
        if(getMinY()<0 || getMaxY()>window.getHeight()) dy=-dy;
        if(this.intersects(window.board)){

            if((y == window.board.y + window.board.height)){
                System.out.println("dol");
                dy=-dy;
            }else if((y == window.board.y - window.board.getHeight())){
                System.out.println("gora");
                dy=-dy;
            }
            else{
                if(window.board.x + 1 == x + d){
                    System.out.println("bok lewy");
                    System.out.println("x");
                    if(dy == -1 && dx == -1){
                        x=x+dx*10;
                    }else if(dy == -1 && dx == 1){
                        dx=-dx;
                    }else if(dy == 1 && dx == -1){
                        System.out.println("x");
                        x=x+dx*10;
                    }else{
                        System.out.println("g,g");
                        dx=-dx;
                    }
                }
                else if(window.board.x + window.board.getWidth() - 1 == x){
                    System.out.println("Bok prawy");
                    if(dy == -1 && dx == -1){
                        dx=-dx;
                    }else if(dy == -1 && dx == 1){
                        x=x+dx*10;
                    }else if(dy == 1 && dx == -1){
                        dx=-dx;
                    }else{
                        x=x+dx*10;
                    }

                }
            }


        }

        for(int row=0; row<window.tiles.length; row++)
            for(int col=0; col < window.tiles[row].length; col++){
                window.tiles[row][col].isHited(this);
            }

        window.repaint();
        Toolkit.getDefaultToolkit().sync();
    }

    public void setDestinationX(){
        this.dx=-this.dx;
    }

    public void setDestinationY(){
        this.dy=-this.dy;
    }

    public double getRadius(){
        return this.r;
    }
}