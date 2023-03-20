import java.awt.*;
import javax.swing.JPanel;


public class GameArea extends JPanel {     //this is area for drawing rectangles and shit
    private int gridRows;
    private int gridColumns;
    private int gridCellSize;
    private TetrisBlock block;

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
        spawnBlock();   // initializing Game Area with fresh copy of TetrisBlock
    }
    public void spawnBlock(){
        block = new TetrisBlock(new boolean[][]{{true, true}, {true,false}, {true, false}}, Color.blue);
        block.spawn(gridColumns);
    }
    public void moveBlockDown(){
        if(!checkBottom()) return;
        block.moveDown();
        repaint();

    }
    public boolean checkBottom(){
        if(block.getBottomEdge() == gridRows) {
            return false;
        }
        return true;
    }
    public void drawBlock(Graphics g){
        int h = block.getHeight();
        int w = block.getWidth();
        boolean[][] s = block.getShape();
        Color c = block.getColor();

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(s[i][j]){       // simplified version of block[i][j] == true
                    int x = (block.getX() + j) * gridCellSize;
                    //int x = j * gridCellSize;
                    int y = (block.getY() + i) * gridCellSize;
                    //int y = i * gridCellSize;
                    g.setColor(c);
                    g.fillRect(x, y, gridCellSize, gridCellSize);
                    g.setColor(Color.black);
                    g.drawRect(x, y, gridCellSize, gridCellSize);
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