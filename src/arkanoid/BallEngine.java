package arkanoid;

public class BallEngine extends Thread{

    private Ball ball;
    public int time = 10;

    public BallEngine(Ball ball){
        this.ball = ball;
        start();
    }

    public void run(){
        try{
            while(true){
                ball.nextStep();
                sleep(10);
            }
        }catch(InterruptedException e){
            e.getMessage();
        }
    }
}
