import java.awt.*;
import javax.swing.JPanel;


public class GameArea extends JPanel {     //this is area for drawing rectangles
    private int gridRows;
    private int gridColumns;
    private int gridCellSize;
    private TetrisBlock block;
    private Color[][] background;

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
        background = new Color[gridRows][gridColumns];
        background[0][0] = Color.green;
    }
    public void spawnBlock(){
        block = new TetrisBlock(new boolean[][]{{true, true}, {true,false}, {true, false}}, Color.red);
        block.spawn(gridColumns);
    }
    public boolean moveBlockDown(){
        if(checkBottom()) {
            moveBlockToBackground();
            return true;
        }
        block.moveDown();
        repaint();
        return false;

    }
    public boolean checkBottom(){
        if(block.getBottomEdge() == gridRows) {
            return true;
        }
        return false;
    }
    public void moveBlockToBackground(){
        boolean[][] shape = block.getShape();
        Color color = block.getColor();
        int h = block.getHeight();
        int w = block.getWidth();
        int xPos = block.getX();
        int yPos = block.getY();
        for(int r=0; r<h; r++){
            for(int c=0; c<w; c++){
                if(shape[r][c]){
                    background[r + yPos][c + xPos] = color;
                }
            }
        }
    }
    public void drawBlock(Graphics g){
        int h = block.getHeight();
        int w = block.getWidth();
        boolean[][] s = block.getShape();
        Color color = block.getColor();

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(s[i][j]){       // simplified version of block[i][j] == true
                    int x = (block.getX() + j) * gridCellSize;
                    int y = (block.getY() + i) * gridCellSize;
                    drawGridSquare(g, color, x, y);
                }
            }
        }
    }
    public void drawBackground(Graphics g){
        Color color;
        for (int row=0; row < gridRows; row++){
            for(int col=0; col < gridColumns; col++){
                color = background[row][col];
                if(color != null){
                    int x = col * gridCellSize;
                    int y = row * gridCellSize;
                    drawGridSquare(g, color, x, y);
                }
            }
        }
    }
    public void drawGridSquare(Graphics g, Color color, int x, int y){
        g.setColor(color);
        g.fillRect(x, y, gridCellSize, gridCellSize);
        g.setColor(Color.black);
        g.drawRect(x, y, gridCellSize, gridCellSize);

    }
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        //g.fillRect(0, 0, 50, 100);
        for(int y=0; y<gridRows; y++){
            for(int x=0; x<gridColumns; x++){
                g.setColor(Color.lightGray);
                g.drawRect(x * gridCellSize, y * gridCellSize, gridCellSize, gridCellSize);
            }
        }
        //g.drawRect(300, 900, 45, 45);
        drawBackground(g);
        drawBlock(g);
    }
}