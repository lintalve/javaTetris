import java.awt.Color;

public class TetrisBlock {
    private boolean[][] shape;
    private Color color;
    private int x, y;
    public TetrisBlock(boolean[][] shape, Color color){  //constructor
        this.shape = shape;
        this.color = color;
    }
    public void spawn(int gridWidth){
        y = 0 - getHeight();
        x = gridWidth/2 - getWidth()/2;
    }
    public boolean[][] getShape(){return shape;}
    public Color getColor(){return color;}
    public int getHeight(){return shape.length;}
    public int getWidth(){return shape[0].length;}
    public int getX(){return x;}
    public int getY(){return y;}
    public void moveDown(){y++;}
    public void moveRight(){x++;}
    public void moveLeft(){x--;}
    public int getBottomEdge(){return y + getHeight();}
}
