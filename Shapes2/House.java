import java.awt.Color;
import java.awt.Graphics;

public class House {
    private int xPosition;
    private int yPosition;
    //rectangle to represent base ofhouse triangle to represent roof
    private Rect body;
    private Triangle roof1;

    public House(int xPosition, int yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        //hard coded white color for the house so its always white 
        this.body = new Rect(xPosition-30,yPosition+100, Canvas.getColor("white"));
        //hard coded cyan color for the roof of the house so its always cyan
        this.roof1 = new Triangle(xPosition, yPosition-100, 200, 100, Canvas.getColor("cyan"));
    }
    public void makeVisible() {
        //make each part of the object visible
        body.makeVisible();
        roof1.makeVisible();
    }
    //give the x and y cordinates of the house when it is drawn for clarity
    public String toString() {
        return "x : " + xPosition + " y : " + yPosition;
    }
}
