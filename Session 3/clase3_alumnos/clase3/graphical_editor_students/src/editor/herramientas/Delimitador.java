package editor.herramientas;

public class Delimitador
{
    private int initialX;
    private int initialY;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    
    public Delimitador(final int x, final int y) {
        this.x2 = x;
        this.x1 = x;
        this.initialX = x;
        this.y2 = y;
        this.y1 = y;
        this.initialY = y;
    }
    
    public Delimitador(final int x1, final int y1, final int x2, final int y2) {
        this.setDimension(x1, y1, x2, y2);
    }
    
    public void resizeTo(final int x, final int y) {
        this.setDimension(this.initialX, this.initialY, x, y);
    }
    
    private void setDimension(final int x1, final int y1, final int x2, final int y2) {
        this.x1 = ((x1 <= x2) ? x1 : x2);
        this.x2 = ((x2 >= x1) ? x2 : x1);
        this.y1 = ((y1 <= y2) ? y1 : y2);
        this.y2 = ((y2 >= y1) ? y2 : y1);
    }
    
    public int getX() {
        return this.x1;
    }
    
    public int getY() {
        return this.y1;
    }
    
    public int getWidth() {
        return this.x2 - this.x1;
    }
    
    public int getHeight() {
        return this.y2 - this.y1;
    }
    
    @Override
    public String toString() {
        return String.format("(%d, %d), (%d, %d)", this.x1, this.y1, this.x2, this.y2);
    }
}
