import java.awt.*;
import javax.swing.JPanel;


public class GameArea extends JPanel {     //this is area for drawing rectangles and shit
    private int gridRows;
    private int gridColumns;
    private int gridCellSize;

    public GameArea(JPanel placeHolder,int columns) {
        placeHolder.setVisible(false);
        //this.setBounds(100, 50, 100, 100);
        this.setBounds(placeHolder.getBounds());
        //this.setBackground(Color.red);
        this.setBackground(placeHolder.getBackground());
        this.setBorder(placeHolder.getBorder());

        gridColumns = columns;
        gridCellSize = this.getBounds().width / gridColumns;
        //gridCellSize = 60;
        System.out.println(gridCellSize);
        gridRows = this.getBounds().height / gridCellSize;
        //gridRows = 7;
    }
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        //g.fillRect(0, 0, 50, 100);
        for(int i=0; i<gridRows; i++){
            for(int j=0; j<gridColumns; j++){
                g.drawRect(i * gridCellSize, j * gridCellSize, gridCellSize, gridCellSize);
            }
        }
    }
}