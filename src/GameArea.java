import java.awt.*;
import javax.swing.JPanel;


public class GameArea extends JPanel {     //this is area for drawing rectangles and shit
    private int gridRows;
    private int gridColumns;
    private int gridCellSize;
    private boolean[][] block = {{true, true}, {true, false}, {true, false}};
    private int initialCoordinate;

    public GameArea(JPanel placeHolder,int columns) {
        placeHolder.setVisible(false);
        this.setBounds(placeHolder.getBounds());
        this.setBackground(placeHolder.getBackground());
        this.setBorder(placeHolder.getBorder());

        gridColumns = columns;
        System.out.println(columns);
        gridCellSize = this.getBounds().width / gridColumns;
        System.out.println(gridCellSize);
        gridRows = this.getBounds().height / gridCellSize;
        System.out.println(gridRows);
    }

    public void drawBlock(Graphics g){
        for(int i=0; i<block.length; i++){
            for(int j=0; j<block[0].length; j++){
                if(block[i][j]){       // simplified version of block[i][j] == true
                    g.setColor(Color.red);
                    g.fillRect(i * gridCellSize, j * gridCellSize, gridCellSize, gridCellSize);
                    g.setColor(Color.black);
                    g.drawRect(i * gridCellSize, j * gridCellSize, gridCellSize, gridCellSize);
                }
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        //g.fillRect(0, 0, 50, 100);
        for(int x=0; x<32; x++){
            for(int y=0; y<gridRows; y++){
                g.setColor(Color.lightGray);
                g.drawRect(x * gridCellSize, y * gridCellSize, gridCellSize, gridCellSize);
            }
        }
        //g.drawRect(300, 900, 45, 45);
        drawBlock(g);
    }
}