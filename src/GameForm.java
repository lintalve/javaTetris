import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class GameForm extends JFrame{

    private JFrame frame;
    private JPanel gameAreaPlaceHolder;

    /**
     * Create the application.
     */
    public GameForm() {

        initialize();

    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        gameAreaPlaceHolder = new JPanel();
        gameAreaPlaceHolder.setBounds(150, 0, 450, 600);
        int width = gameAreaPlaceHolder.getWidth();
        frame = new JFrame();
        frame.setBounds(400, 200, 1000, 600);
        gameAreaPlaceHolder.setBounds(frame.getBounds().width/2 - width/2, 0, 450, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //JButton btnPress = new JButton("Press");
        GameArea gas = new GameArea(gameAreaPlaceHolder,10);
        frame.getContentPane().add(gas, BorderLayout.CENTER);
        frame.getContentPane().setLayout(null);
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