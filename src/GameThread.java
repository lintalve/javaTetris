public class GameThread extends Thread {
    final private GameArea ga;

    public GameThread(GameArea ga) {
        this.ga = ga;
    }

    @Override
    public void run() {

        while (true) {
            ga.spawnBlock();
            while (!ga.moveBlockDown()) {
                try {
                    Thread.sleep(550);
                    //ga.moveBlockDown();
                }catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }
}


