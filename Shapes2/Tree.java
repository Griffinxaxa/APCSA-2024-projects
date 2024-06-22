import java.awt.Graphics;
import java.awt.Color;

public class Tree {
    private int xPosition;
    private int yPosition;
    private String leafColor;
    private Rect rectangle;
    private Circle circleOne;
    private Circle circleTwo;
    private Circle circleThree;

    public Tree(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.leafColor = "green";
        //hard coded brown color for the tree to look realistic
        this.rectangle = new Rect(xPosition-120 ,yPosition+75, Canvas.getColor("brown"));
        this.circleOne = new Circle(85, xPosition - 100, yPosition, Canvas.getColor("green"));
        //hard coded green colors for realistic leaves as well.
        this.circleTwo = new Circle(85, xPosition - 150, yPosition, Canvas.getColor("green"));
        this.circleThree = new Circle(85, xPosition - 190, yPosition, Canvas.getColor("green"));
    }

    public void makeVisible()
     {
         //make each part of the tree visible
         rectangle.makeVisible();
         circleOne.makeVisible();
         circleTwo.makeVisible();
         circleThree.makeVisible();
     } 
    //return the x and y cordinates of the tree when it is drawn for clarity.
    public String toString()
    {
        return "x: " + xPosition + "y: " + yPosition;                                                                                                                                                                                                                                                                                                                                                                               
    }
}
