public class GameThread extends Thread{
    private GameArea ga;
    public GameThread(GameArea ga){
        this.ga = ga;
    }
    @Override
    public void run(){
        try {
            while(true) {

                System.out.println("this is thread printing some stuff");
                Thread.sleep(650);

                ga.moveBlockDown();
                Thread.sleep(750);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
