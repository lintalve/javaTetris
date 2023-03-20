import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class GameForm extends JFrame{

    private JFrame frame;
    private JPanel gameAreaPlaceHolder;
    public GameArea ga;

    public GameForm() {
        final int gaphWidth = 600;
        final int gaphHeight = 1000;
        final int gaphCells = 10;
        gameAreaPlaceHolder = new JPanel();
        gameAreaPlaceHolder.setBounds(150, 0, gaphWidth, gaphHeight);
        int width = gameAreaPlaceHolder.getWidth();
        frame = new JFrame();
        frame.setBounds(400, 200, 1000, gaphHeight);
        gameAreaPlaceHolder.setBounds(frame.getBounds().width/2 - width/2, 0, gaphWidth, gaphHeight);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.ga = new GameArea(gameAreaPlaceHolder,gaphCells);
        frame.getContentPane().add(ga, BorderLayout.CENTER);
        frame.getContentPane().setLayout(null);
        startGame();

    }
    public void startGame(){
        new GameThread(ga).start();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GameForm window = new GameForm();
                    window.frame.setVisible(true);
                    //window.frame.pack();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}