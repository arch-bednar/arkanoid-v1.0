package arkanoid;

import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Window extends JPanel implements MouseMotionListener{

    public Board board;
    private Ball ball;
    private BallEngine engine;
    public Tile[][] tiles = new Tile[3][10];


    public Window(){
        super();
        addMouseMotionListener(this);

        //Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        //int width = (int) screen.getWidth();
        //int height = (int) screen.getHeight();

        //int boardWidth = (int) (width*0.01);
        //int boardHeight = (int) (height*0.01);

        //this.board = new Board(boardWidth, boardHeight);
        this.board = new Board(100, 7);
        this.ball = new Ball(this, 10);
        this.engine = new BallEngine(ball);
    }

    public void initTiles(int windowWidth, int windowHeight){
        int tileHeight = 28;
        int tileWidth = 58;

        int y = 1;
        for(int row=0; row < tiles.length; row++){
            int x = 1;
            for(int col=0; col<tiles[row].length; col++){
                tiles[row][col] = new Tile(x, y, tileWidth, tileHeight);

                x = x + tileWidth + 1;
            }
            y = y + tileHeight + 1;
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.black);
        g2d.fill(ball);
        g2d.fill(board);

        for(int row=0; row < tiles.length; row++){
            for(int col=0; col<tiles[row].length; col++){
                if(tiles[row][col].getStatus()){
                    g2d.setColor(Color.black);
                    g2d.fill(tiles[row][col]);
                }else {
                    g2d.setColor(Color.white);
                    g2d.fill(tiles[row][col]);
                }
            }
        }

    }

    public void mouseMoved(MouseEvent e){
        board.setX(e.getX()-50);
        //System.out.println(e.getX());
        repaint();
    }

    public void mouseDragged(MouseEvent e){

    }

}