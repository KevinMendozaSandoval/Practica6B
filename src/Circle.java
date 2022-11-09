import java.awt.Color;
public class Circle
{
    private int xPos;
    private int yPos;
    private int diametro;
    private Canvas canvas;
    private Color color;
    
    /**
     * Crea un circulo y lo dibuja
     */
    public Circle(int xPos, int yPos, int diametro, Color color, Canvas canvas)
    {
        this.canvas = canvas; //Canvas donde se dibujará
        this.color = color;
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPos, yPos, diametro);
    }
}
