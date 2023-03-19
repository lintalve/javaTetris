import java.awt.Color;

public class TetrisBlock {
    private boolean[][] shape;
    private Color color;
    private int x, y;
    public TetrisBlock(boolean[][] shape, Color color){
        this.shape = shape;
        this.color = color;
        this.x = 3;
        this.y = 2;
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
}
