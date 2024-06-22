import java.awt.Graphics;
import java.awt.Color;

/**
 * A cloud that draws itself on a canvas.
 */

public class Cloud
{
    private int xPosition;
    private int yPosition;
    private Circle circle1, circle2, circle3, circle4, circle5, circle6;
    private Color color;
        
    /**
     * Create a new cloud at (xPosition, yPosition) with default color.
     */
    public Cloud(int xPosition, int yPosition)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        color = Canvas.getColor("white");
        
        circle1 = new Circle(85, xPosition - 100, yPosition, color);
        circle2 = new Circle(100, xPosition - 60, yPosition - 60, color);
        circle3 = new Circle(90, xPosition - 45, yPosition + 5, color);
        circle4 = new Circle(120, xPosition, yPosition -80, color);
        circle5 = new Circle(120, xPosition, yPosition - 10, color);
        circle6 = new Circle(120, xPosition + 60, yPosition -40, color);
    }
    
    /**
     * Make this cloud visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        circle1.makeVisible();
        circle2.makeVisible();
        circle3.makeVisible();
        circle4.makeVisible();
        circle5.makeVisible();
        circle6.makeVisible();
    }

    /**
     * toString method for a cloud
     */
    public String toString()
    {
        return ("There is a cloud at (" + xPosition + ", " + yPosition + ").");
    }
}
